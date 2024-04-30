package abby.trinketlantern;

import dev.emi.trinkets.SurvivalTrinketSlot;
import dev.emi.trinkets.api.SlotGroup;
import dev.emi.trinkets.api.TrinketsApi;
import dev.emi.trinkets.data.SlotLoader;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TrinketLantern implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("trinketlantern");


	public static final Item CARRY_LANTERN = new Item(new FabricItemSettings().maxCount(1));
	public static final Item CARRY_SOUL_LANTERN = new Item(new FabricItemSettings().maxCount(1));

	public static final Item CARRY_LANTERN_WATERPROOF = new Item(new FabricItemSettings().maxCount(1));
	public static final Item CARRY_SOUL_LANTERN_WATERPROOF = new Item(new FabricItemSettings().maxCount(1));

	@Override
	public void onInitialize() {
		Registry.register(Registries.ITEM, new Identifier("trinketlantern", "carry_lantern"), CARRY_LANTERN);
		Registry.register(Registries.ITEM, new Identifier("trinketlantern", "carry_soul_lantern"), CARRY_SOUL_LANTERN);

		Registry.register(Registries.ITEM, new Identifier("trinketlantern", "carry_lantern_waterproof"), CARRY_LANTERN_WATERPROOF);
		Registry.register(Registries.ITEM, new Identifier("trinketlantern", "carry_soul_lantern_waterproof"), CARRY_SOUL_LANTERN_WATERPROOF);

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> {
			content.add(CARRY_LANTERN);
			content.add(CARRY_SOUL_LANTERN);

			content.add(CARRY_LANTERN_WATERPROOF);
			content.add(CARRY_SOUL_LANTERN_WATERPROOF);
		});
	}
}