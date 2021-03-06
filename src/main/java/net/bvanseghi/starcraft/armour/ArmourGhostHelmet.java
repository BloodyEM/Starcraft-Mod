package net.bvanseghi.starcraft.armour;

import net.bvanseghi.starcraft.lib.REFERENCE;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ArmourGhostHelmet extends ItemArmor {

	public static final String name = "ghostHelmet";

	public ArmourGhostHelmet(ArmorMaterial armourMaterial, int renderIndex, int armourType) {
		super(armourMaterial, renderIndex, armourType);
 		this.setCreativeTab(null);
		this.setUnlocalizedName(REFERENCE.Unlocalized_Path + name);
		this.setTextureName(REFERENCE.Texture_Path + name);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		return null; //"Starcraft:textures/model/armor/copper_layer_1.png";
	}
}
