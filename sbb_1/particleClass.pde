public class particle extends PVector{
	PVector vel;

	public particle (PVector loc, PVector vel) {
		super(loc.x,loc.y);
		this.vel = vel.get();

	}

	public void updateParticle(){
		
	}

	public void particleHit(Block bhit){

	}

}