package com.Toturial.toturial.ModCommands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;

public class LoginCommand implements Command<CommandSourceStack> {
    public static LoginCommand instance = new LoginCommand();

    @Override
    public int run(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        String string = StringArgumentType.getString(context,"passwd");
        Player player = context.getSource().getPlayer();
        if (string.equals("123456")) {
            player.sendSystemMessage(Component.literal("密码正确!"));
        }
        else player.sendSystemMessage(Component.literal("密码错误！"));
        return 0;
    }

}

