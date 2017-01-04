package net.bvanseghi.starcraft.entity;

import java.util.Random;

import net.bvanseghi.starcraft.entity.monster.EntityProtossMob;
import net.bvanseghi.starcraft.events.SCSoundEvent;
import net.bvanseghi.starcraft.events.SCSoundEvents;
import net.bvanseghi.starcraft.items.ModItems;
import net.bvanseghi.starcraft.lib.StarcraftConfig;
import net.bvanseghi.starcraft.weapons.ModWeapons;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class EntityZealot extends EntityProtossMob {

//	private boolean field_146076_bu = false;
//	private float field_146074_bv = -1.0F;
//	private float field_146073_bw;
    
	public EntityZealot(World world) {
		   
		super(world);
		clearAITasks();
	    this.setSize(1.5F, 2.5F);
	    /*
	     * TODO: recreate entity ai.
	     */
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(StarcraftConfig.zealotHP);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.39000000417232513D);
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(32.0D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(StarcraftConfig.zealotDmg);
	}
	
	protected void clearAITasks()
	{
	   tasks.taskEntries.clear();
	   targetTasks.taskEntries.clear();
	}

	public boolean isAIEnabled()
    {
        return true;
    }
	
	public SCSoundEvent getLivingSound() {
		Random rand = new Random();
		if(rand.nextInt(2) == 0) {
			return SCSoundEvents.ENTITY_ZEALOT_LIVE1;
		}else if(rand.nextInt(2) == 1) {
			return SCSoundEvents.ENTITY_ZEALOT_LIVE2;
		}else if(rand.nextInt(2) == 2) {
			return SCSoundEvents.ENTITY_ZEALOT_LIVE3;
		}
		return SCSoundEvents.ENTITY_ZEALOT_LIVE4;
	}
	
	public SCSoundEvent getHurtSound() {
		return SCSoundEvents.ENTITY_ZEALOT_HURT;
	}
	
	public SCSoundEvent getDeathSound() {
		return SCSoundEvents.ENTITY_ZEALOT_DEATH;
	}
	
	public int getTalkInterval()
    {
        return 160;
    }
	
    /**
     * Drop 0-2 items of this living's type. @param par1 - Whether this entity has recently been hit by a player. @param
     * par2 - Level of Looting used to kill this mob.
     */
    protected void dropFewItems(boolean p_70628_1_, int p_70628_2_)
    {
        int j = this.rand.nextInt(50);
        if(j == 50) {
            this.dropItem(ModWeapons.psiBlade, 1);
        }else if(j < 5) {
        	this.dropItem(ModItems.energy, 1);
        }
    }
	
	@Override
	public void onUpdate()
	{
		super.onUpdate();
	}
	
	@Override
	public boolean attackEntityFrom(DamageSource p_70097_1_, float p_70097_2_)
    {
        return super.attackEntityFrom(p_70097_1_, p_70097_2_);
    }
}



