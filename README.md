# Hourglass Sand / 时间之沙

![Icon](./HourglassSandIcon.png)

![License](https://img.shields.io/badge/License-MIT-green.svg)
![Minecraft Version](https://img.shields.io/badge/Minecraft-1.21.8%2B-blue)
[![Modrinth Downloads](https://img.shields.io/modrinth/dt/hourglass-sand?color=00AF5C&label=Modrinth&logo=modrinth)](https://modrinth.com/mod/hourglass-sand)
[![Mod Loader](https://img.shields.io/badge/loader-Fabric-1976d2?logo=fabric)](https://modrinth.com/discover/mods?g=categories:fabric)

A simple item that lets you control time flow. Pause, slow down, speed up, or reset your world with a single click. / 一个简单的物品，让你掌控时间流速。只需一次点击，就能暂停、慢放、加速或恢复正常时间。

## Features / 特性

- **One item to rule time** – Right-click the **Hourglass Sand** to open a GUI with four modes / **一个物品掌控时间** – 手持**时间之沙**右键打开GUI，四种模式可选
- **Four modes** – Stop (freeze), Slow (0.5x), Normal (1x), Fast (2x) / **四种模式** – 停止（冻结）、慢放（0.5倍）、正常（1倍）、快速（2倍）
- **Multiplayer ready** – Works for all players on the server / **多人游戏支持** – 服务器内所有玩家共享时间设置
- **No commands needed** – Just click and play / **无需指令** – 点击即用，无需记忆任何指令
- **Lightweight** – No dependencies, no config files, no performance impact / **轻量级** – 无依赖、无配置文件、无性能影响

## How it works / 工作原理

This mod uses Minecraft's built-in `/tick` command. When you select a mode, it executes the corresponding command: / 这个模组使用 Minecraft 原生的 `/tick` 指令。当你选择模式时，它会执行对应的指令：

| Mode / 模式 | Command / 指令 |
|-------------|----------------|
| Stop / 停止 | `/tick freeze` `/tick unfreeze` |
| Slow / 慢放 | `/tick rate 10` |
| Normal / 正常 | `/tick rate 20` |
| Fast / 快速 | `/tick rate 40` |

## Crafting Recipe / 合成配方

```
[  ][Obsidian][  ]
[Soul Sand][Clock][Redstone]
[  ][Sand][  ]
```

- **Clock** / 时钟
- **Obsidian** / 黑曜石
- **Soul Sand** / 灵魂沙
- **Redstone** / 红石粉
- **Sand** / 沙子

## Installation / 安装

Drop the jar file into your `mods` folder. That's it. / 将jar文件放入 `mods` 文件夹即可。
