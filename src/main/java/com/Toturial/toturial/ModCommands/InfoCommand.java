package com.Toturial.toturial.ModCommands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;

public class InfoCommand implements Command<CommandSourceStack> {
    public static InfoCommand instance = new InfoCommand();

    @Override
    public int run(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        Player player = context.getSource().getPlayer();
        player.sendSystemMessage(Component.literal(""+player.getX()+" "+player.getY()+" "+player.getZ()));
        return 0;
    }

}
