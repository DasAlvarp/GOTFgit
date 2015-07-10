package com.alvarpq.GOTF.coreGame.cards;
import java.lang.reflect.InvocationTargetException;
import com.alvarpq.GOTF.coreGame.effect.Enchantment;
public class EnchantmentFactory
{
	private Class<? extends Enchantment> enchantment;
	public EnchantmentFactory(Class<? extends Enchantment> enchantment)
	{
		this.enchantment = enchantment;
	}
	public Enchantment create() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, SecurityException
	{
		return (Enchantment)enchantment.getConstructors()[0].newInstance();
	}
}