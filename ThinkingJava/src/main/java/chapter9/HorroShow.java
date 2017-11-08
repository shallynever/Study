package chapter9;

interface Monster{
	void menace();
}
interface DangerousMonster extends Monster{
	void destroy();
}
interface Lethal{
	void kill();
}
class DragonZilla implements DangerousMonster{
	public void menace() {
	}
	public void destroy() {
	}	
}
interface Vampire extends DangerousMonster,Lethal{
	void drinkBlood();
}
class VeryBadVmapire implements Vampire{
	public void destroy() {
	}
	public void menace() {
	}
	public void kill() {
	}
	public void drinkBlood() {
	}	
}
public class HorroShow {	
	static void  u(Monster b){b.menace();}
	static void v(DangerousMonster d ){
		d.menace();
		d.destroy();
	}
	static void w(Lethal l){l.kill();}
	public static void main(String[] args) {
		DangerousMonster barney = new DragonZilla();
		u(barney);
		v(barney);
		Vampire vlad = new VeryBadVmapire();
		u(vlad);
		v(vlad);
		w(vlad);
	}

}
