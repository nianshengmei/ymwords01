package com.ym.common.vocabuary;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ym.common.util.translation.youdao.CollinsDictionary;
import com.ym.common.util.vocabuary.Conjugate;
import com.ym.common.util.vocabuary.ExampleSentence;
import com.ym.common.util.vocabuary.SimpleVocabuary;
import com.ym.common.util.vocabuary.Synonym;

import java.util.List;

public class WordUtils {

    public static com.ym.bean.Word toWordBean(com.ym.common.vocabuary.Word word){
        com.ym.bean.Word w = new com.ym.bean.Word();
        Gson gson = new Gson();
        w.setAmericanPhoneticSymbol(word.getAmericanPhoneticSymbol());
        w.setBilingualExample(gson.toJson(word.getBilingualExample()));
        w.setCollins(gson.toJson(word.getCollins()));
        w.setConjugate(gson.toJson(word.getConjugate()));
        w.setEnglishPhoneticSymbol(word.getEnglishPhoneticSymbol());
        w.setId(word.getId());
        w.setInterpretation(gson.toJson(word.getInterpretation()));
        w.setSynonyms(gson.toJson(word.getSynonyms()));
        w.setWebInterpretation(gson.toJson(word.getWebInterpretation()));
        w.setWord(word.getWord());
        return w;
    }


    public static Word toVocabularyWord(com.ym.bean.Word word){
        Word w = new Word();
        Gson gson = new Gson();
        w.setAmericanPhoneticSymbol(word.getAmericanPhoneticSymbol());
        w.setBilingualExample((List<ExampleSentence>) gson.fromJson(word.getBilingualExample(),new TypeToken<List<ExampleSentence>>(){}.getType()));
        w.setCollins(gson.fromJson(word.getCollins(), CollinsDictionary.class));
        w.setConjugate(gson.fromJson(word.getConjugate(), Conjugate.class));
        w.setEnglishPhoneticSymbol(word.getEnglishPhoneticSymbol());
        w.setId(word.getId());
        w.setInterpretation((List<String>) gson.fromJson(word.getInterpretation(),new TypeToken<List<String>>(){}.getType()));
        w.setSynonyms((List<Synonym>) gson.fromJson(word.getSynonyms(),new TypeToken<List<Synonym>>(){}.getType()));
        w.setWebInterpretation((List<SimpleVocabuary>) gson.fromJson(word.getWebInterpretation(),new TypeToken<List<SimpleVocabuary>>(){}.getType()));
        w.setWord(word.getWord());
        return w;
    }

    public String backInterpretation(List<String> as){
        String ret="";
        if(as.size()<=0){
            return ret;
        }
        for(String s:as){
            ret+=s;
        }
        return ret;
    }

}
