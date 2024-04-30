package abby.trinketlantern;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;

import java.util.function.Consumer;

public class TrinketLanternDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(ModelGenerator::new);
		pack.addProvider(LanguageGenerator::new);
	}

	private class ModelGenerator extends FabricModelProvider {
		public ModelGenerator(FabricDataOutput output) {
			super(output);
		}

		@Override
		public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

		}

		@Override
		public void generateItemModels(ItemModelGenerator itemModelGenerator) {
			itemModelGenerator.register(TrinketLantern.CARRY_LANTERN, Models.GENERATED);
			itemModelGenerator.register(TrinketLantern.CARRY_SOUL_LANTERN, Models.GENERATED);

			itemModelGenerator.register(TrinketLantern.CARRY_LANTERN_WATERPROOF, Models.GENERATED);
			itemModelGenerator.register(TrinketLantern.CARRY_SOUL_LANTERN_WATERPROOF, Models.GENERATED);
		}
	}

	private class LanguageGenerator extends FabricLanguageProvider {

		protected LanguageGenerator(FabricDataOutput dataOutput) {
			super(dataOutput);
		}

		@Override
		public void generateTranslations(TranslationBuilder translationBuilder) {
			translationBuilder.add(TrinketLantern.CARRY_LANTERN, "Wearable Lantern");
			translationBuilder.add(TrinketLantern.CARRY_SOUL_LANTERN, "Wearable Soul Lantern");

			translationBuilder.add(TrinketLantern.CARRY_LANTERN_WATERPROOF, "Wearable Waterproof Lantern");
			translationBuilder.add(TrinketLantern.CARRY_SOUL_LANTERN_WATERPROOF, "Wearable Waterproof Soul Lantern");

			translationBuilder.add("trinkets.slot.legs.lantern", "Wearable Lantern");
		}
	}

	private static class MyRecipeGenerator extends FabricRecipeProvider {
		private MyRecipeGenerator(FabricDataOutput generator) {
			super(generator);
		}

		@Override
		public void generate(Consumer<RecipeJsonProvider> exporter) {
			ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TrinketLantern.CARRY_LANTERN)
					.pattern("l")
					.pattern("t")
					.pattern("i")
					.input('l', Items.LEATHER)
					.input('t', Items.LANTERN)
					.input('i', Items.IRON_NUGGET)
					.criterion(FabricRecipeProvider.hasItem(Items.LANTERN),
							FabricRecipeProvider.conditionsFromItem(Items.LANTERN))
					.offerTo(exporter);


			ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TrinketLantern.CARRY_SOUL_LANTERN)
					.pattern("l")
					.pattern("t")
					.pattern("i")
					.input('l', Items.LEATHER)
					.input('t', Items.SOUL_LANTERN)
					.input('i', Items.IRON_NUGGET)
					.criterion(FabricRecipeProvider.hasItem(Items.SOUL_LANTERN),
							FabricRecipeProvider.conditionsFromItem(Items.SOUL_LANTERN))
					.offerTo(exporter);

			ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TrinketLantern.CARRY_LANTERN_WATERPROOF)
					.pattern(" g ")
					.pattern("gtg")
					.pattern(" g ")
					.input('g', Blocks.GLASS_PANE)
					.input('t', TrinketLantern.CARRY_LANTERN)
					.criterion(FabricRecipeProvider.hasItem(TrinketLantern.CARRY_LANTERN),
							FabricRecipeProvider.conditionsFromItem(TrinketLantern.CARRY_LANTERN))
					.offerTo(exporter);


			ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, TrinketLantern.CARRY_SOUL_LANTERN_WATERPROOF)
					.pattern(" g ")
					.pattern("gtg")
					.pattern(" g ")
					.input('g', Blocks.GLASS_PANE)
					.input('t', TrinketLantern.CARRY_SOUL_LANTERN)
					.criterion(FabricRecipeProvider.hasItem(TrinketLantern.CARRY_SOUL_LANTERN),
							FabricRecipeProvider.conditionsFromItem(TrinketLantern.CARRY_SOUL_LANTERN))
					.offerTo(exporter);
		}
	}
}
