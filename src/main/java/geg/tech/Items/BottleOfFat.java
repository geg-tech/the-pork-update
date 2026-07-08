package geg.tech.Items;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;

import java.util.function.Consumer;

public class BottleOfFat extends Item {
    public BottleOfFat(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext tooltipContext, TooltipDisplay tooltipDisplay, Consumer<Component> builder, TooltipFlag tooltipFlag) {
        builder.accept(Component.translatable("tooltip.porkin.fatbottle").withStyle(ChatFormatting.DARK_GRAY));
        //add tooltips
        super.appendHoverText(itemStack, tooltipContext, tooltipDisplay, builder, tooltipFlag);
    }
}

