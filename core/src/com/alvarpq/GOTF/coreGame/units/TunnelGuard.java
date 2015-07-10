package com.alvarpq.GOTF.coreGame.units;
import com.alvarpq.GOTF.coreGame.board.BoardHalf;
import com.alvarpq.GOTF.coreGame.event.UnitDamagedEvent;
import com.alvarpq.GOTF.coreGame.event.UnitDamagedListener;
import com.alvarpq.GOTF.entity.AnimatedSprite;
public class TunnelGuard extends Unit implements UnitDamagedListener
{
	private int armorValue = 1;
	public TunnelGuard(int row, int column)
	{
		super("Tunnel Guard", 1, 2, 4, 1, new String[]{"Mulgoon", "Soldier"}, row, column);
	}
	@Override
	public void applyPresence(BoardHalf myHalf, BoardHalf opponentsHalf){}
	@Override
	public AnimatedSprite getSprite(){return null;}
	@Override
	public void update(){}
	@Override
	public void onUnitDamaged(UnitDamagedEvent event)
	{
		if(event.getDamagedUnit()==this&&armorValue>0)
		{
			//reverts damage
			heal(event.getAmount());
			armorValue--;
		}
	}
}
