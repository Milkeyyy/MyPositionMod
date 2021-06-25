package ml.milkeyyy.myposition.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.World;
import net.minecraft.entity.Entity;

import ml.milkeyyy.myposition.MypositionModVariables;
import ml.milkeyyy.myposition.MypositionMod;

import java.util.Map;
import java.util.HashMap;

public class UpdateMypositionProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
			if (event.phase == TickEvent.Phase.END) {
				Entity entity = event.player;
				World world = entity.world;
				double i = entity.getPosX();
				double j = entity.getPosY();
				double k = entity.getPosZ();
				Map<String, Object> dependencies = new HashMap<>();
				dependencies.put("x", i);
				dependencies.put("y", j);
				dependencies.put("z", k);
				dependencies.put("world", world);
				dependencies.put("entity", entity);
				dependencies.put("event", event);
				executeProcedure(dependencies);
			}
		}
	}
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MypositionMod.LOGGER.warn("Failed to load dependency entity for procedure UpdateMyposition!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((entity.getCapability(MypositionModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new MypositionModVariables.PlayerVariables())).showmyposition) == (true))) {
			{
				String _setval = (String) (("X/Y/Z: ") + "" + ((new java.text.DecimalFormat("##.#").format((entity.getPosX())))) + "" + ("/") + ""
						+ ((new java.text.DecimalFormat("##.#").format((entity.getPosY())))) + "" + ("/") + ""
						+ ((new java.text.DecimalFormat("##.#").format((entity.getPosZ())))));
				entity.getCapability(MypositionModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Myposition = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((((entity.getCapability(MypositionModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new MypositionModVariables.PlayerVariables())).showmyposition) == (false))) {
			{
				String _setval = (String) "";
				entity.getCapability(MypositionModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Myposition = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
