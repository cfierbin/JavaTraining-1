import java.util.ArrayList;
import java.util.List;
import com.practicaljava.custom.IVoiceInput;
import com.practicaljava.custom.LgNexus;
import com.practicaljava.custom.MobilePhone;
import com.practicaljava.custom.AppleIPhone;

/**
 * @author Svyatoslav Strygin <svyatoslav.strygin@gmail.com>
 */
public class TestMobliePhones {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		MobilePhone mobilePhones[] = new MobilePhone[2];
		mobilePhones[0] = new AppleIPhone();
		mobilePhones[1] = new LgNexus();

		List<IVoiceInput> voiceInputDevices = new ArrayList<IVoiceInput>();

		for (MobilePhone mobilePhone : mobilePhones) {
			mobilePhone.powerOn();
			mobilePhone.runWebBrowser();
			mobilePhone.openApplicationMarket();
			voiceInputDevices.add((IVoiceInput) mobilePhone);
		}

		for (IVoiceInput voiceInputDevice : voiceInputDevices) {
			voiceInputDevice.runVoiceListener();
		}

	}

}
