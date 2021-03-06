package com.eone.bot.telegram.updates.response;

import com.eone.bot.db.model.FopNorm;

public class FopToMessageConverter {

    public static String getLFO(FopNorm fopNorm) {
        return fopNorm.getLast_name() + " " + fopNorm.getFirst_name() + " " + fopNorm.getOther_name();
    }

    public static String formatOutput(FopNorm fop) {

        return "`" + getLFO(fop) + "`\n"
                + "_" + fop.getAddress() + "_\n"
                + fop.getActivity() + "\n "
                + "*" + fop.getStatus() + "*";

    }
}
