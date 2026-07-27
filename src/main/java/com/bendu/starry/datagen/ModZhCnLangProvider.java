package com.bendu.starry.datagen;

import com.bendu.starry.StarryMod;
import com.bendu.starry.block.ModBlocks;
import com.bendu.starry.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public class ModZhCnLangProvider extends LanguageProvider {
    public ModZhCnLangProvider(PackOutput output) {
        super(output, StarryMod.MOD_ID, "zh_cn");
    }

    @Override
    protected void addTranslations() {
        add(ModItems.GOLDEN_TEAR_CRYSTAL.get(), "金泪晶石");
        add(ModItems.MEMORANDUM.get(), "备忘录");
        add(ModItems.ORIGINAL_STAR_INGOT.get(), "原星锭");
        add(ModItems.SHATTERED_STAR_CRYSTAL.get(), "碎星水晶");
        add(ModItems.WAIT.get(), "‘等待’");
        add(ModItems.RAW_ORIGINAL_STAR.get(), "粗原星");
        add(ModItems.CLOUD_LYCHEE.get(), "云荔");
        add(ModItems.HELP.get(), "‘互助’");
        add(ModItems.PERSEVERANCE.get(), "‘坚持’");
        add(ModItems.HALF_STAR_SWORD.get(), "半星剑");

        add(ModBlocks.ORIGINAL_STAR_ORE.get(), "原星矿石");

        add("itemGroup.starry_material", "星忆梦片原材料");
        add("itemGroup.starry_blocks", "星忆梦片方块");
        add("itemGroup.starry_curios", "星忆梦片饰品");

        add("curios.identifier.stellar_tome", "星箓");
        add("curios.identifier.memory_fragment", "记忆碎片");
        add("curios.identifier.hands", "手部");

        // golden_tear_crystal
        add("tooltip.starry_mod.golden_tear_crystal.shift_hint", "按住 ");
        add("tooltip.starry_mod.golden_tear_crystal.shift_suffix", " 查看故事");
        add("tooltip.starry_mod.golden_tear_crystal.desc.1", "“说真的，哭解决不了问题，但哭完能解决情绪，偶尔。”");
        add("tooltip.starry_mod.golden_tear_crystal.story.1", "我是一个悲观主义者。如果太过安稳，会怀疑用现在的平静交换了未来的什么悲剧；太过痛苦，就会联想马上崩溃的结局。但悲观也让我获得了好处——至少我不会因为坏结局而伤心很久，反而认为是正常现象，觉得故事就该有个坏结局。");
        add("tooltip.starry_mod.golden_tear_crystal.story.2", "我承认，是光太刺眼，让我流了泪，不是和你的对话。忘记一个人需要多久？如果它真的没那么重要，你会很快忘了它。可偏偏，它就是你曾经的一部分。");

        // original_star_ingot
        add("tooltip.starry_mod.original_star_ingot.shift_hint", "按住 ");
        add("tooltip.starry_mod.original_star_ingot.shift_suffix", " 查看故事");
        add("tooltip.starry_mod.original_star_ingot.desc.1", "“看起来像海......”");
        add("tooltip.starry_mod.original_star_ingot.desc.2", "“明明是天空的颜色。”");
        add("tooltip.starry_mod.original_star_ingot.story.1", "傍晚的天色一寸寸暗下去，从蔚蓝变成深蓝，再变成紫灰色。可锭的蓝始终不变。");

        // raw_original_star
        add("tooltip.starry_mod.raw_original_star.shift_hint", "按住 ");
        add("tooltip.starry_mod.raw_original_star.shift_suffix", " 查看故事");
        add("tooltip.starry_mod.raw_original_star.desc.1", "“外表被蓝色的粗矿包裹，矿中闪烁着金光，没错！”");
        add("tooltip.starry_mod.raw_original_star.story.1", "至少它闪烁的光芒，应该不来自于这个世界。");

        // cloud_lychee
        add("tooltip.starry_mod.cloud_lychee.shift_hint", "按住 ");
        add("tooltip.starry_mod.cloud_lychee.shift_suffix", " 查看故事");
        add("tooltip.starry_mod.cloud_lychee.desc.1", "“我说实话，这看着像荔枝，吃着凉凉的，但我朋友说像在吃云。”");
        add("tooltip.starry_mod.cloud_lychee.effect", "食用后获得生命恢复 II");
        add("tooltip.starry_mod.cloud_lychee.story.1", "本来想存着舍不得吃，结果放久了……飘走了。唉……");
        add("tooltip.starry_mod.cloud_lychee.story.2", "“云能吃吗？”");

        // half_star_sword effect
        add("tooltip.starry_mod.half_star_sword.effect.bonus", "分辉加成 ");
        add("tooltip.starry_mod.half_star_sword.effect.suffix", " 攻击伤害");

        // half_star_sword
        add("tooltip.starry_mod.half_star_sword.shift_hint", "按住 ");
        add("tooltip.starry_mod.half_star_sword.shift_suffix", " 查看故事");
        add("tooltip.starry_mod.half_star_sword.desc.1", "别太依赖手中的剑，而忘了剑的力量来自何处——");
        add("tooltip.starry_mod.half_star_sword.story.1", "剑士的故事，是自己来书写的。");

        // Shattered Star Crystal tooltip
        add("tooltip.starry_mod.shattered_star_crystal.desc.1", "\u201c你还记得那个下雨的傍晚吗？\u201d");
        add("tooltip.starry_mod.shattered_star_crystal.desc.2", "\u201c记得。你把我贴在窗上偷看外面，哈出的雾气盖住了我的脸。\u201d");
        add("tooltip.starry_mod.shattered_star_crystal.story.1", "三年。");
        add("tooltip.starry_mod.shattered_star_crystal.story.2", "你把她放在离胸口最近的位置，怕碎了，怕冷了，怕别人碰了。");
        add("tooltip.starry_mod.shattered_star_crystal.story.3", "你甚至学会了用左手拿东西，好让右手随时空着——万一她需要什么。");
        add("tooltip.starry_mod.shattered_star_crystal.story.4", "可她没需要过你。不是她冷漠，是她根本不知道那里有个人一直捧着。");
        add("tooltip.starry_mod.shattered_star_crystal.story.5", "最后你没摔，也没人抢。");
        add("tooltip.starry_mod.shattered_star_crystal.story.6", "你只是松开手，因为捧太久了。");
        add("tooltip.starry_mod.shattered_star_crystal.story.7", "掌心磨出了茧，骨头酸了，连心跳都被压得慢了一拍。");
        add("tooltip.starry_mod.shattered_star_crystal.story.8", "她从来不知道自己是玻璃。");
        add("tooltip.starry_mod.shattered_star_crystal.story.9", "她以为她只是正常地走路、说话、笑。");
        add("tooltip.starry_mod.shattered_star_crystal.story.10", "只有你知道，那三年你一直没敢握紧。");
        add("tooltip.starry_mod.shattered_star_crystal.story.11", "怕握疼她，也怕一握紧，她就碎了。");
        add("tooltip.starry_mod.shattered_star_crystal.story.12", "到头来碎的是你自己。");
        add("tooltip.starry_mod.shattered_star_crystal.story.13", "碎成很多片，每一片上面都映着她的侧脸。");
        add("tooltip.starry_mod.shattered_star_crystal.shift_hint", "按住 ");
        add("tooltip.starry_mod.shattered_star_crystal.shift_suffix", " 查看故事");

        // Memorandum tooltip
        add("tooltip.starry_mod.memorandum.stellar_value", "分辉值：");
        add("tooltip.starry_mod.memorandum.desc.1", "\u201c封面是空的。\u201d");
        add("tooltip.starry_mod.memorandum.desc.2", "\u201c里面也是空的。\u201d");
        add("tooltip.starry_mod.memorandum.desc.3", "\u201c第一行字，什么时候才有人写？\u201d");
        add("tooltip.starry_mod.memorandum.shift_hint", "按住 ");
        add("tooltip.starry_mod.memorandum.shift_suffix", " 查看故事");
        add("tooltip.starry_mod.memorandum.story.1", "我不记得自己被写下来过。");
        add("tooltip.starry_mod.memorandum.story.2", "每一页都是白的，翻过去，还是白的。");
        add("tooltip.starry_mod.memorandum.story.3", "风从书脊里穿过，发出细细的声音，像在问：你在这里干什么。");
        add("tooltip.starry_mod.memorandum.story.4", "我不知道。");
        add("tooltip.starry_mod.memorandum.story.5", "也许我在等人翻开我。");
        add("tooltip.starry_mod.memorandum.info.share", "其他人生碎片将共享当前分辉值");
        add("tooltip.starry_mod.memorandum.info.max_value", "当前最大分辉值：");
        add("tooltip.starry_mod.memorandum.info.fragment_slots", "佩戴后解锁6记忆碎片栏位");

        // Wait & Help shift hint
        add("tooltip.starry_mod.wait.shift_hint", "按住 ");
        add("tooltip.starry_mod.wait.shift_suffix", " 查看故事");
        add("tooltip.starry_mod.help.shift_hint", "按住 ");
        add("tooltip.starry_mod.help.shift_suffix", " 查看故事");

        // Wait tooltip
        add("tooltip.starry_mod.wait.shared_value_prefix", "共享分辉值：");
        add("tooltip.starry_mod.wait.desc.1", "\u201c别等了，勇敢踏出去吧\u201d");
        add("tooltip.starry_mod.wait.separator", "\u00a77\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500");
        add("tooltip.starry_mod.wait.desc.2", "这次故地重游不是想念你，而是把以前的\u201c我\u201d接回来。");
        add("tooltip.starry_mod.wait.story.1", "这次故地重游，不是想念你。");
        add("tooltip.starry_mod.wait.story.2", "我反复问过自己：是不是又在借回忆取暖？后来站在这里，风还是当年的方向，我才确定——不是为了你。");
        add("tooltip.starry_mod.wait.story.3", "我是来把以前的\u201c我\u201d接回来的。");
        add("tooltip.starry_mod.wait.story.4", "那个会为一朵云停下来的人，那个相信明天值得期待所以肯安心闭眼的人——他一直困在这条路上。不是他走丢了，是我故意没回头。");
        add("tooltip.starry_mod.wait.story.5", "今天我来接他。我蹲在老树下，把手按进树皮的纹理里，告诉他说抱歉让他等这么久，我不是来怀念谁的，是来接他回家的。");
        add("tooltip.starry_mod.wait.story.6", "面馆换了招牌，醋的味道没变。吃完站起来，觉得有一根骨头轻轻响了一声——有什么东西归位了。");
        add("tooltip.starry_mod.wait.story.7", "这趟旅行与你无关。我只是从废墟底下，把那个敢笑、敢失眠、敢对明天抱有希望的小孩牵了出来。");
        add("tooltip.starry_mod.wait.story.8", "他牵着我的手，说走吧回家。我应了一声好。这次再也不丢下他了。");
        add("tooltip.starry_mod.wait.effect.speed_prefix", "移速");
        add("tooltip.starry_mod.wait.effect.kb_prefix", "  击退抗性");

        // Help tooltip
        add("tooltip.starry_mod.help.shared_value_prefix", "共享分辉值：");
        add("tooltip.starry_mod.help.desc.1", "\u201c原来时间是一个圆。\u201d");
        add("tooltip.starry_mod.help.desc.2", "所谓互助，不过是同一个灵魂在两个坐标里同时伸出手。");
        add("tooltip.starry_mod.help.story.1", "雨下了一整夜。我躺在巷口的积水里，半个身子都泡凉了。偶有路人经过，看我一眼，脚步慢半拍，然后又加快走开。我理解他们——深夜、雨天、一个蜷缩在地上的人，谁都不想惹麻烦。");
        add("tooltip.starry_mod.help.story.2", "直到一把深灰色的伞遮住我的头顶。伞下的年轻人蹲下来，双手托住我的腋下，把我从水里拖到墙边的干燥处。他的外套湿透了，贴在我脸上，冰凉。做完这些，他站起身，转身走进雨里。伞留在我手里。");
        add("tooltip.starry_mod.help.story.3", "我爬起来，借着路灯看见伞柄上刻着两个字——\u201c别谢\u201d。下面还有一行：\u201c是你\u201d。");
        add("tooltip.starry_mod.help.effect.desc_prefix", "夜晚或雨天，若血量低于30%时，获得 ");
        add("tooltip.starry_mod.help.effect.desc_suffix", " 并清除负面效果，且下次治疗/增益对队友也生效");
        add("tooltip.starry_mod.help.effect.absorption", "伤害吸收");
        add("tooltip.starry_mod.help.effect.cooldown", "冷却 120 秒");
        add("tooltip.starry_mod.help.separator", "§7─────────────────────");

        // Perseverance tooltip
        add("tooltip.starry_mod.perseverance.shared_value_prefix", "共享分辉值：");
        add("tooltip.starry_mod.perseverance.shift_hint", "按住 ");
        add("tooltip.starry_mod.perseverance.shift_suffix", " 查看故事");
        add("tooltip.starry_mod.perseverance.desc.1", "“若事与愿违，坚持是否仍有意义？”");
        add("tooltip.starry_mod.perseverance.separator", "§7─────────────────────");
        add("tooltip.starry_mod.perseverance.desc.2", "如果结局不能让你满意，那就还不是结局。");
        add("tooltip.starry_mod.perseverance.story.1", "“所以，我的答案是：如果事与愿违，请先停下来区分——你是在“固执”地撞南墙，还是在“坚韧”地探索？如果是前者，换个方向不是放弃，是智慧；如果是后者，请继续。");
        add("tooltip.starry_mod.perseverance.story.2", "真的猛士，敢于直面惨淡的人生，敢于正视淋漓的鲜血。这是怎样的哀痛者和幸福者？然而造化又常常为庸人设计，以时间的流驶，来洗涤旧迹，仅使留下淡红的血色和微漠的悲哀。在这淡红的血色和微漠的悲哀中，又给人暂得偷生，维持着这似人非人的世界。我不知道这样的世界何时是一个尽头！————《记念刘和珍君》");
        add("tooltip.starry_mod.perseverance.effect.low_prefix", "当共享分辉值低于100，当前获得 +");
        add("tooltip.starry_mod.perseverance.effect.high_prefix", "当共享分辉值高于100，每高1点加 +");
        add("tooltip.starry_mod.perseverance.effect.suffix", "% 生命上限");
        add("tooltip.starry_mod.perseverance.effect.attack_prefix", "每高10点加 +");
        add("tooltip.starry_mod.perseverance.effect.attack_suffix", "% 攻击伤害");
        add("tooltip.starry_mod.perseverance.effect.active", "【生效中】");
        add("tooltip.starry_mod.perseverance.effect.inactive", "【未生效】");

        // Choice tooltip
        add(ModItems.CHOICE.get(), "\u2018\u9009\u62e9\u2019");
        add("tooltip.starry_mod.choice.shared_value_prefix", "\u5171\u4eab\u5206\u8f89\u503c\uff1a");
        add("tooltip.starry_mod.choice.shift_hint", "\u6309\u4f4f ");
        add("tooltip.starry_mod.choice.shift_suffix", " \u67e5\u770b\u6545\u4e8b");
        add("tooltip.starry_mod.choice.desc.1", "\u843d\u5b50\u65e0\u6094\u3002");
        add("tooltip.starry_mod.choice.separator", "\u00a77\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500");
        add("tooltip.starry_mod.choice.desc.2", "\u5343\u4e07\u4e2a\u7ed3\u5c40\u4e5f\u8bb8\u771f\u6709\u90a3\u4e2a\u6700\u5b8c\u7f8e\u7684\uff0c\u4f46\u5982\u679c\u4e0d\u6562\u9009\u62e9\uff0c\u9009\u62e9\u4e86\u60f3\u540e\u6094\uff0c\u9009\u62e9\u4e86\u62b1\u6028\u8fc7\u53bb\uff0c\u9009\u62e9\u4e86\u4e0d\u6562\u9762\u5bf9\u73b0\u5728\uff0c\u90a3\u4f60\u4f1a\u5728\u9009\u62e9\u53e6\u4e00\u4e2a\u65f6\u4e5f\u5982\u6b64\u3002");
        add("tooltip.starry_mod.choice.story.1", "\u6211\u8bb0\u5f97\u7237\u7237\u6559\u6211\u4e0b\u68cb\u65f6\u8bf4\u7684\u552f\u4e00\u4e00\u53e5\u8bdd\u2014\u2014\"\u843d\u5b50\u65e0\u6094\u3002\"\u5f53\u65f6\u6211\u4e3e\u7740\u68cb\u5b50\u60ac\u5728\u534a\u7a7a\uff0c\u60f3\u6362\u4e2a\u4f4d\u7f6e\u3002\u4ed6\u6309\u4f4f\u4e86\u6211\u7684\u624b\u3002\u4ed6\u8bf4\uff0c\u8fd9\u4e16\u4e0a\u6ca1\u6709\u5b8c\u7f8e\u7684\u68cb\uff0c\u53ea\u6709\u4f60\u4e0b\u4e86\u3001\u7136\u540e\u8d70\u4e0b\u53bb\u7684\u68cb\u3002\u540e\u6765\u6211\u7ad9\u5728\u4eba\u751f\u7684\u5dee\u8def\u53e3\uff0c\u60f3\u8d77\u90a3\u4e2a\u5348\u540e\u3002\u9633\u5149\u7a7f\u8fc7\u69d0\u6811\u53f6\uff0c\u843d\u5728\u68cb\u76d8\u4e0a\u3002\u6211\u843d\u4e86\u5b50\uff0c\u6ca1\u518d\u56de\u5934\u3002");
        add("tooltip.starry_mod.choice.effect.low_prefix", "\u5f53\u5171\u4eab\u5206\u8f89\u503c\u5c0f\u4e8e100\u65f6\uff1a\u653b\u51fb\u529b +");
        add("tooltip.starry_mod.choice.effect.low_suffix", "%");
        add("tooltip.starry_mod.choice.effect.high_line", "\u5f53\u5171\u4eab\u5206\u8f89\u503c\u5927\u4e8e100\u65f6\uff1a\u83b7\u5f97200\u5907\u5fd8\u5f55\u5206\u8f89\u503c\u4e0a\u9650");
        add("tooltip.starry_mod.choice.effect.active", "\u3010\u751f\u6548\u4e2d\u3011");
        add("tooltip.starry_mod.choice.effect.inactive", "\u3010\u672a\u751f\u6548\u3011");
        // Narrator subtitles
        add("subtitles.starry_mod.narrator.memorandum_first_equip", "这是测试文本1，在备忘录首次装备时生效");

    }
}
