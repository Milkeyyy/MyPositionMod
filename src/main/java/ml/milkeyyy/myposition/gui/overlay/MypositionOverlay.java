
package ml.milkeyyy.myposition.gui.overlay;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.Minecraft;

import ml.milkeyyy.myposition.MypositionModVariables;

@Mod.EventBusSubscriber
public class MypositionOverlay {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGameOverlayEvent event) {
		if (!event.isCancelable() && event.getType() == RenderGameOverlayEvent.ElementType.HELMET) {
			int posX = (event.getWindow().getScaledWidth()) / 2;
			int posY = (event.getWindow().getScaledHeight()) / 2;
			PlayerEntity entity = Minecraft.getInstance().player;
			World world = entity.world;
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			if (true) {
				Minecraft
						.getInstance().fontRenderer
								.drawString(event.getMatrixStack(),
										"" + ((entity.getCapability(MypositionModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new MypositionModVariables.PlayerVariables())).Myposition) + "",
										posX + -207, posY + -112, -1);
			}
		}
	}
}
