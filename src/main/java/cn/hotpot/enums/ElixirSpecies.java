package cn.hotpot.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author qinzhu
 * 丹药种类
 */
@AllArgsConstructor
@Getter
public enum ElixirSpecies {
    /**
     * 凡丹
     */
    FAN(0, 600),

    /**
     * 灵丹
     */
    LING(1, 550),

    /**
     * 奇丹
     */
    QI(2, 500),

    /**
     * 地丹
     */
    DI(3, 450),

    /**
     * 天丹
     */
    TIAN(4, 400);

    /**
     * 序列，方便使用索引操作
     */
    private Integer seq;

    /**
     * 成功几率，取值范围[0,1000]
     * e.g. 500表示成功几率为千分之五百
     */
    private Integer chanceOfSuccess;

    /**
     * 获得控火经验
     *
     * @param doAlchemySuccess 是否炼丹成功
     */
    public Integer getFireControlExperience(Boolean doAlchemySuccess) {
        int result;
        switch (this) {
            case FAN:
                result = 2;
                break;
            case LING:
                result = 6;
                break;
            case QI:
                result = 11;
                break;
            case DI:
                result = 16;
                break;
            case TIAN:
                result = 21;
                break;
            default:
                result = 0;
        }
        return doAlchemySuccess ? result : result / 2;
    }

    /**
     * 获得炼丹等级经验
     */
    public Integer getAlchemyExperience(Boolean doAlchemySuccess) {
        int result;
        switch (this) {
            case FAN:
                result = 100;
                break;
            case LING:
                result = 300;
                break;
            case QI:
                result = 500;
                break;
            case DI:
                result = 700;
                break;
            case TIAN:
                result = 900;
                break;
            default:
                result = 0;
        }
        return doAlchemySuccess ? result : result / 2;
    }
}
