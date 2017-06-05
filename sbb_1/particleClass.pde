public class particle extends PVector{
	PVector vel;
	PVector pOrigin;
	public particle (PVector loc, PVector vel) {
		super(loc.x,loc.y);
		this.vel = vel.get();

	}

	public void launchParticle(PVector loc, PVector mousePos) {
		//create n particles with velocity from origin
	}

	public void updateParticle(){
		//add velocity
		
	}

	public void particleHit(boolean bhit_b, Block bhit){
		//if hit block, affect block, then reflect off block

		//if hit bottom, check origin set
		//if hit top or sides, reflect.
	}


	public void drawParticle(){
		//draw particle
	};
}