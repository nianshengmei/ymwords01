package com.ym.test;

import com.ym.common.util.translation.youdao.YouDaoTrans;
import com.ym.common.vocabuary.Word;

import java.util.ArrayList;
import java.util.List;

public class RepiteYoudaoByStringWord {

    public static List<Word> getAllWordsByPageNum(List<String> allWords,int[] ids){
        List<Word> ret = new ArrayList<Word>();
        for(int i =0;i<ids.length;i++){
            int id = ids[i];
            String query = allWords.get(id);
                  Word w = YouDaoTrans.queryWord(query);
                  ret.add(w);
        }
        return ret;
    }
}
