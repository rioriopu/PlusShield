package com.github.pentantan.shield.item;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Item 
{
	public static Item WoodShield;{
WoodShield = getRegisteredItem("woodshield");
    }
	private Item getRegisteredItem(String string) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
	public static net.minecraft.item.Item getItemFromBlock(Block planks) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
	public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
}