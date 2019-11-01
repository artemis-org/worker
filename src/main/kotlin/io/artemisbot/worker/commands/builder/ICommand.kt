package io.artemisbot.worker.commands.builder

interface ICommand {
    fun root(ctx: CommandContext)
}