package Ch35;

public class Main {

	public static void main(String[] args) {
		Marine marine1 = new Marine();
		marine1.setGun(new pistol());
		marine1.setType("marine1");
		Marine marine2 = new Marine();
		marine2.setGun(new rifle());
		marine2.setType("marine2");
		Medic medic1 = new Medic();
		medic1.type ="medic1";

		// marine1 -> marine2 공격

		Thread attack1Thread = new Thread() {
			public void run() {
				while (!marine2.isDead) {
					try {
						marine1.attack(marine2);
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		// marine2 -> marine1 공격
		Thread attack2Thread = new Thread() {
			public void run() {
				while (!marine1.isDead) {
					try {
						marine2.attack(marine1);
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};

		// medic1 -> marine1 회복
		Thread medicThread = new Thread() {
			public void run() {
				while (!marine1.isDead) {
					try {
						medic1.healing(marine1);
						Thread.sleep(1500);
					} catch (Exception e) {
						e.printStackTrace();
					}

				}
			}
		};
		
        
		attack1Thread.start();
        attack2Thread.start();
        medicThread.start();
	}
}