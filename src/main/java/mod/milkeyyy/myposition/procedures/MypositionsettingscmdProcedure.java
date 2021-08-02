package mod.milkeyyy.myposition.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import mod.milkeyyy.myposition.MypositionModVariables;
import mod.milkeyyy.myposition.MypositionMod;

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
			{
				String _setval = (String) "ON";
				entity.getCapability(MypositionModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.showpositionstatus = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(
						new StringTextComponent((((("\u00A7l[\u00A76\u00A7l") + "" + (MypositionModVariables.MapVariables.get(world).ModName) + ""
								+ ("\u00A7r\u00A7l]\u00A7r "))) + "" + ((new TranslationTextComponent("message.myposition.enabled").getString())))),
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
			{
				String _setval = (String) "OFF";
				entity.getCapability(MypositionModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.showpositionstatus = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(
						new StringTextComponent((((("\u00A7l[\u00A76\u00A7l") + "" + (MypositionModVariables.MapVariables.get(world).ModName) + ""
								+ ("\u00A7r\u00A7l]\u00A7r "))) + "" + ((new TranslationTextComponent("message.myposition.disabled").getString())))),
						(false));
			}
		}
	}
}
