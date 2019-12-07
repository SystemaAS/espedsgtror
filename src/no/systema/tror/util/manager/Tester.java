package no.systema.tror.util.manager;

public class Tester {

	public static void main(String[] args) {
		AWBManager mgr = new AWBManager();
		String awb = "89898980000";
		System.out.println(mgr.getAwbPrefix(awb));
		System.out.println(mgr.getAwbSuffix(awb));
	}
}


