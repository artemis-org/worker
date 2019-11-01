package io.artemisbot.worker.commands.impl.general

import io.artemisbot.worker.commands.builder.Category
import io.artemisbot.worker.commands.builder.CommandContext
import io.artemisbot.worker.commands.builder.ICommand
import io.artemisbot.worker.commands.builder.PermissionLevel
import io.artemisbot.worker.commands.builder.annotations.*

class HelpCommand : ICommand {

    @CommandName("help")
    @CommandDescription("Shows you a list of commands")
    @CommandAliases(["h"])
    @CommandCategory(Category.GENERAL)
    @CommandPermission(PermissionLevel.DEFAULT)
    override fun root(ctx: CommandContext) {

    }
}