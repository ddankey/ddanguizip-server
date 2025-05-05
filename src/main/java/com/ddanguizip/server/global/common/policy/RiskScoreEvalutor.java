package com.ddanguizip.server.global.common.policy;

import org.springframework.stereotype.Component;

@Component
public class RiskScoreEvalutor {
    public double calculatorScore(double agingRate, double dredgingRate, boolean isDanger) {
        double score =(agingRate * 0.6) + ((100 - dredgingRate) * 0.4);
        if(isDanger) {
            score+=5;
        }
        return score;
    }

    public int fromScoreByDong(double score) {
        if (score >= 75) return 3;
        else if (score >= 50) return 2;
        else if (score >= 25) return 1;
        else return 0;
    }

    public double calculatorRatio(int count, int total) {
        return (double) count / total;
    }

    public int fromRatioByGu(double ratio) {
        if (ratio >= 0.6) return 3;
        else if (ratio >= 0.4) return 2;
        else if (ratio >= 0.2) return 1;
        else return 0;
    }
}
