var FormatUtils = new function ()
{
    var thisRef = this;

    thisRef.formatUSCurrency = function (value, fractionDigits, decimalSeparator, groupSeparator)
    {
        //Format given value to string in US number format.
        if (fractionDigits == null || isNaN(fractionDigits) || fractionDigits < 0)
        {
            fractionDigits = 2;
        }

        if (typeof (value) == "string")
        {
            if (value == "-" || value == "&ndash;" || value == "&mdash;")
                return "-";
            if (value == "")
                return value;

            value = parseFloat(value);
        }

        if (isNaN(value) || !isFinite(value))
        {
            return "-";
        }

        decimalSeparator = decimalSeparator || ".";
        groupSeparator = groupSeparator || ",";
        var v = Math.abs(value);
        var t = v % 1;
        var fixed = t.toFixed(fractionDigits);
        var res = fixed.replace(".", decimalSeparator);
        res = res.substring(1, res.length);
        v = Math.floor(v);
        if (fixed >= 1.0)
        {
            v += 1;
        }

        while (v >= 1000)
        {
            t = v % 1000;

            res = t + res;
            if (t < 10)
            {
                res = "00" + res;
            } else if (t < 100)
            {
                res = "0" + res;
            }
            res = groupSeparator + res;

            v = Math.floor(v / 1000);
        }

        res = v.toString() + res;

        if (value < 0)
        {
            res = "-" + res;
        }

        return res;
    };

    thisRef.parseUSCurrency = function (textValue, precision)
    {
        //Parse given string value to number. Precision is optional and by default equals 2.
        return parseFloat(thisRef.prepareUSCurrencyToParse(textValue, precision));
    };

    thisRef.prepareUSCurrencyToParse = function (textValue, precision)
    {
        //Replace separators in given string and returns it. Precision is optional and by default equals 2.
        if (typeof (textValue) == "undefined")
        {
            return NaN;
        }
        if (typeof (textValue) == "number")
        {
            return textValue;
        }

        if (typeof (precision) != "number" || precision < 0)
        {
            precision = 2;
        }

        var preResult = textValue.replace(/[\s,]/g, '');
        ;
        var dotIndex = preResult.indexOf('.');

        if (dotIndex != -1)
        {
            preResult = preResult.replace(/[\$%,\(\) \u00a0]/g, "");
            if (preResult.charAt(preResult.length - 1 - precision) != '.')
            {
                preResult = preResult + "0";
            }
        }

        return preResult;
    };

    thisRef.roundTo = function (value, digits)
    {
        //Round given float to number with digits after dot.
        var power = Math.pow(10, digits);
        var temp = Math.round(value * power);
        return temp / power;
    };

    thisRef.formatUSCurrencySpinner = function (control, value)
    {
        return thisRef.formatUSCurrency(value, control.params.precision);
    };

    thisRef.daysBeetweenDates = function (sDate, eDate)
    {
        //Calculate days count between dates
        return (Math.abs(Math.ceil((sDate - eDate) / 86400000)) + 1);
    };

    thisRef.formatUSCurrencyString = function (value, fractionDigits, decimalSeparator, groupSeparator)
    {
        var val = ko.utils.getValue(value);
        if ((val == 0) || (parseFloat(val) && !(/[a-z]/i.exec(val))))
        {
            var digits = 4;
            if (fractionDigits)
                digits = fractionDigits;

            return FormatUtils.formatUSCurrency(val, digits, decimalSeparator, groupSeparator);
        }
        return val;
    };
    
    thisRef.formatDecimalToString = function (decValue)
    {
        if (Math.abs(decValue) >= 1000000)
            return ((decValue / 1000000).toFixed(1) + 'M');
        if (Math.abs(decValue) >= 1000)
            return ((decValue / 1000).toFixed(1) + 'K');
        return decValue;
    };

    thisRef.getNumericValue = function(anyValue, fractionDigits)
    {
        var value = ko.utils.getValue(anyValue);
        if (value)
        {
            var parsed = parseFloat(value);
            if (parsed)
            {
                return isNaN(parsed)
                    ? 0
                    : isNaN(parseInt(fractionDigits))
                        ? parsed
                        : parsed.toFixed(fractionDigits) * 1;
            }
        }
        return 0;
    };
    
    thisRef.trailingFormat = function(value, isAbsolute, currencySymbol)
    {
        return (value < 0 ? '-' : '')
            + (isAbsolute ? currencySymbol : '')
            + FormatUtils.formatUSCurrency(Math.abs(value))
            + (isAbsolute ? '' : '%');
    };
};
