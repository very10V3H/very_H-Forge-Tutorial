package com.Toturial.toturial.ModCommands;

import com.Toturial.toturial.Utils;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.tree.LiteralCommandNode;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class CommandHandler {
    @SubscribeEvent
    public static void onServerStarting(RegisterCommandsEvent event) {

        CommandDispatcher<CommandSourceStack> dispatcher2 = event.getDispatcher();
        LiteralCommandNode<CommandSourceStack> cmd2 = dispatcher2.register(
                Commands.literal(Utils.MOD_ID).then(
                        Commands.literal("info")
                                .executes(InfoCommand.instance)
                )
        );

        CommandDispatcher<CommandSourceStack> dispatcher0 = event.getDispatcher();
        LiteralCommandNode<CommandSourceStack> cmd0 = dispatcher0.register(
                Commands.literal(Utils.MOD_ID).then(
                        Commands.literal("login").then(
                                Commands.argument("passwd", StringArgumentType.string())
                                        .requires(commandSourceStack -> commandSourceStack.hasPermission(0))
                                        .executes(LoginCommand.instance)
                        )
                )
        );
    }
}
