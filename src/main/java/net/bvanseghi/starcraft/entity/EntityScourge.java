package net.bvanseghi.starcraft.entity;

import net.bvanseghi.starcraft.entity.monster.EntityProtossMob;
import net.bvanseghi.starcraft.entity.monster.EntityTerranMob;
import net.bvanseghi.starcraft.entity.monster.EntityZergMob;
import net.bvanseghi.starcraft.entity.passive.EntityProtossPassive;
import net.bvanseghi.starcraft.entity.passive.EntityTerranPassive;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityScourge extends EntityZergMob {

	public EntityScourge(World world) {
		super(world);
		this.setSize(0.3F, 0.3F);
		this.tasks.addTask(0, new EntityAISwimming(this));
		
		
        this.tasks.addTask(0, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
        this.tasks.addTask(0, new EntityAIAttackOnCollide(this, EntityTerranPassive.class, 1.0D, true));
        this.tasks.addTask(0, new EntityAIAttackOnCollide(this, EntityProtossPassive.class, 1.0D, true));
        
        this.tasks.addTask(0, new EntityAIAttackOnCollide(this, EntityTerranMob.class, 1.0D, true));
        this.tasks.addTask(0, new EntityAIAttackOnCollide(this, EntityProtossMob.class, 1.0D, true));
        
        
        this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
        this.targetTasks.addTask(0, new EntityAIHurtByTarget(this, true));
        
        this.targetTasks.addTask(0, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
        this.targetTasks.addTask(0, new EntityAINearestAttackableTarget(this, EntityTerranPassive.class, 0, false));
        this.targetTasks.addTask(0, new EntityAINearestAttackableTarget(this, EntityProtossPassive.class, 0, false));
        
        this.targetTasks.addTask(0, new EntityAINearestAttackableTarget(this, EntityTerranMob.class, 0, false));
        this.targetTasks.addTask(0, new EntityAINearestAttackableTarget(this, EntityProtossMob.class, 0, false));
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(15.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.43000000417232513D);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(32.0D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(2.0D);
	}

	public boolean isAIEnabled()
    {
        return true;
    }
	
	protected void dropFewItems(boolean par1, int par2) {

	}
}



