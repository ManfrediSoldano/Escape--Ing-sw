package it.polimi.ingsw.cg_10.controller.server;

/**
 * @author Manfredi
 *
 */
public class Counter extends Thread {
	private int time;
	private int id;
	private ServerGameCentral sgc;

	
	public Counter(int time, int id, ServerGameCentral sgc){
		this.time=time*1000;
		this.id=id;
		this.sgc = sgc;
	}

	@Override
	public void run(){
		ServerGameCentral.getSercommunication().publish("[SYSTEM] mancano "+time+" secondi all'inizio della paritia.", id);
		int halftime =time/2;
		try {
			Thread.sleep(halftime);
		} catch (InterruptedException e) {}
		ServerGameCentral.getSercommunication().publish("[SYSTEM] mancano "+halftime/1000+" secondi all'inizio della paritia.", id);
		try {
			Thread.sleep(halftime-5000);
		} catch (InterruptedException e) {}
		ServerGameCentral.getSercommunication().publish("[SYSTEM] mancano 5 secondi all'inizio della paritia.", id);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {}
		ServerGameCentral.getSercommunication().publish("[SYSTEM] 3.", id);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {}
		ServerGameCentral.getSercommunication().publish("[SYSTEM] 2.", id);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {}

		
		ServerGameCentral.getSercommunication().publish("[SYSTEM] 1.", id);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {}
		ServerGameCentral.getSercommunication().publish("[SYSTEM]Partita inziata.", id);
		sgc.stopCounter(id);

    }

	
	
}
