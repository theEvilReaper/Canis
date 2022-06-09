package net.theevilreaper.canis.banner;

import org.jetbrains.annotations.NotNull;

/**
 * Represents a loaded pattern from a banner.
 * @param color the color from the banner
 * @param pattern the pattern as string
 * @author theEvilReaper
 * @version 1.0.0
 * @since 1.0.0
 */
public record BannerPattern(int color, @NotNull String pattern) {}
