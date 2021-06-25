package ml.milkeyyy.myposition.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import ml.milkeyyy.myposition.MypositionModVariables;
import ml.milkeyyy.myposition.MypositionMod;

import java.util.Map;

public class MypositionsettingscmdProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MypositionMod.LOGGER.warn("Failed to load dependency entity for procedure Mypositionsettingscmd!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				MypositionMod.LOGGER.warn("Failed to load dependency world for procedure Mypositionsettingscmd!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		if ((((entity.getCapability(MypositionModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new MypositionModVariables.PlayerVariables())).showmyposition) == (false))) {
			{
				boolean _setval = (boolean) (true);
				entity.getCapability(MypositionModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.showmyposition = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(
						new StringTextComponent((((("\u00A7l[\u00A76\u00A7l") + "" + (MypositionModVariables.MapVariables.get(world).ModName) + ""
								+ ("\u00A7r\u00A7l]\u00A7r "))) + "" + ("MyPosition \u00A7aEnabled\u00A7r."))),
						(false));
			}
		} else if ((((entity.getCapability(MypositionModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new MypositionModVariables.PlayerVariables())).showmyposition) == (true))) {
			{
				boolean _setval = (boolean) (false);
				entity.getCapability(MypositionModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.showmyposition = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(
						new StringTextComponent((((("\u00A7l[\u00A76\u00A7l") + "" + (MypositionModVariables.MapVariables.get(world).ModName) + ""
								+ ("\u00A7r\u00A7l]\u00A7r "))) + "" + ("MyPosition \u00A7cDisabled\u00A7r."))),
						(false));
			}
		}
	}
}
