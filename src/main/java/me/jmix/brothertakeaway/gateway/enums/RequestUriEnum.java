package me.jmix.brothertakeaway.gateway.enums;

import lombok.Getter;

/**
 * @author JellyfishMIX
 * @date 2020/7/25 22:43
 */
@Getter
public enum RequestUriEnum {
    ORDER("/brother-takeaway-order");

    private String preUri;

    RequestUriEnum(String preUri) {
        this.preUri = preUri;
    }
}
