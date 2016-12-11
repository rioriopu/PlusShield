package com.github.pentantan.shield;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;

@Mod(modid = Plusshield.MOD_ID,
        name = Plusshield.MOD_NAME,
        version = Plusshield.MOD_VERSION,
        dependencies = Plusshield.MOD_DEPENDENCIES,
        acceptedMinecraftVersions = Plusshield.MOD_ACCEPTED_MC_VERSIONS,
        useMetadata = true)
public class Plusshield{
    /** ModID文字列 */
    public static final String MOD_ID = "plusshield";
    /** MOD名称 */
    public static final String MOD_NAME = "PlusShield";
    /** MODのバージョン */
    public static final String MOD_VERSION = "0.0.1";
    /** 前に読み込まれるべき前提MODをバージョン込みで指定 */
    public static final String MOD_DEPENDENCIES = "required-after:Forge@[1.10-12.18.2.2099,)";
    /** 起動出来るMinecraft本体のバージョン。記法はMavenのVersion Range Specificationを検索すること。 */
    public static final String MOD_ACCEPTED_MC_VERSIONS = "[1.10]";
	public static Item woodshield;
	public static Object TabSSCore;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event){
    	woodshield = new Item()
        .setCreativeTab(CreativeTabs.COMBAT)
        .setUnlocalizedName("woodshield")/*システム名の登録*/
        /*.setHasSubtypes(true)*//*ダメージ値等で複数の種類のアイテムを分けているかどうか。デフォルトfalse*/
    	.setMaxDamage(60)/*.setMaxDamage(256)*//*耐久値の設定。デフォルト0*/
        /*.setFull3D()*//*3D表示で描画させる。ツールや骨、棒等。*/
        /*.setContainerItem(Items.stick)*//*クラフト時にアイテムを返却できるようにしている際の返却アイテムの指定。*/
        /*.setPotionEffect(PotionHelper.ghastTearEffect)*//*指定文字列に対応した素材として醸造台で使える。PotionHelper参照のこと。*/
        /*.setNoRepair()*//*修理レシピを削除し、金床での修繕を出来なくする*/
        .setMaxStackSize(1);/*スタックできる量。デフォルト64*/
        //アイテムの登録。登録文字列はMOD内で被らなければ何でも良い。
        GameRegistry.register(woodshield, new ResourceLocation(MOD_ID, "woodshield"));
 
        //テクスチャ・モデル指定JSONファイル名の登録。
        if(event.getSide().isClient()){
            //1IDで複数モデルを登録するなら、上のメソッドで登録した登録名を指定する。
            ModelLoader.setCustomModelResourceLocation(woodshield, 0, new ModelResourceLocation(woodshield.getRegistryName(), "inventory"));
        }
        
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event){
        GameRegistry.addRecipe(new ItemStack(woodshield),
                "# #",
                "###",
                "#",
                '#', Blocks.PLANKS
                );
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event){
   }

	public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}