package com.alvarpq.GOTF.requirement;
public interface Requirement
{
	public RequirementType getType();
	public boolean isFulfilled();
	public void reset();
}