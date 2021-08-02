package mod.milkeyyy.myposition.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.entity.Entity;

import mod.milkeyyy.myposition.MypositionMod;

import java.util.Map;
import java.util.HashMap;

public class OpenSettingScreenKeyPressedProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MypositionMod.LOGGER.warn("Failed to load dependency entity for procedure OpenSettingScreenKeyPressed!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				MypositionMod.LOGGER.warn("Failed to load dependency world for procedure OpenSettingScreenKeyPressed!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		{
			Map<String, Object> $_dependencies = new HashMap<>();
			$_dependencies.put("entity", entity);
			$_dependencies.put("world", world);
			MypositionsettingscmdProcedure.executeProcedure($_dependencies);
		}
	}
}
