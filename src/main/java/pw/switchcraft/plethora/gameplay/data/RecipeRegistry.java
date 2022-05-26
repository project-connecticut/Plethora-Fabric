package pw.switchcraft.plethora.gameplay.data;

import net.minecraft.data.server.recipe.ComplexRecipeJsonBuilder;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.recipe.SpecialRecipeSerializer;
import net.minecraft.util.registry.Registry;
import pw.switchcraft.plethora.gameplay.modules.kinetic.KineticRecipe;
import pw.switchcraft.plethora.gameplay.modules.laser.LaserRecipe;

import java.util.function.Consumer;

public class RecipeRegistry {
    public static void addDynamicRecipes(Consumer<RecipeJsonProvider> exporter) {
        // TODO: Dummy recipe hint for kinetic augment's potions
//        ShapedRecipeJsonBuilder
//            .create(Registration.ModItems.KINETIC_MODULE, 1)
//            .pattern("RGR")
//            .pattern("PBP")
//            .pattern("RGR")
//            .input('P', Blocks.PISTON)
//            .input('R', ConventionalItemTags.REDSTONE_DUSTS)
//            .input('B', Blocks.PISTON)
//            .input('G', ConventionalItemTags.GOLD_INGOTS)
//            .criterion("has_redstone", inventoryChange(ConventionalItemTags.REDSTONE_DUSTS)) // TODO
//            .offerTo(exporter);

        addSpecial(exporter, KineticRecipe.SERIALIZER);
        addSpecial(exporter, LaserRecipe.SERIALIZER);

        // TODO: Dummy recipe hint for laser's enchanted books
//        ItemStack[] item = getItemsEnchantedWith(Map.of(
//            Enchantments.FLAME, 1,
//            Enchantments.FIRE_ASPECT, 1
//        ));
//
//        for (int i = 0; i < item.length; i++) {
//            ItemStack stack = item[i];
//            ShapedRecipeJsonBuilder
//                .create(Registration.ModItems.LASER_MODULE, 1)
//                .pattern("III")
//                .pattern("GDF")
//                .pattern("  I")
//                .input('F', stack.getItem())
//                .input('D', ConventionalItemTags.DIAMONDS)
//                .input('G', ConventionalItemTags.GLASS_BLOCKS)
//                .input('I', ConventionalItemTags.IRON_INGOTS)
//                .criterion("has_diamond", inventoryChange(ConventionalItemTags.DIAMONDS)) // TODO
//                .offerTo(exporter, new Identifier(MOD_ID, "laser_module_" + i));
//        }
    }

    private static void addSpecial(Consumer<RecipeJsonProvider> exporter, SpecialRecipeSerializer<?> special) {
        var key = Registry.RECIPE_SERIALIZER.getId(special);
        ComplexRecipeJsonBuilder.create(special).offerTo(exporter, key.toString());
    }
}
