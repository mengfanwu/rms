//package com.mengfw.helper;
//
//import org.apache.lucene.analysis.Analyzer;
//import org.apache.lucene.analysis.TokenStream;
//import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
//import org.wltea.analyzer.lucene.IKAnalyzer;
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by MFW on 2017/5/24.
// */
//public class LunceneHelper {
//
//    public static List<String> getWords(String str, Analyzer analyzer){
//        List<String> result = new ArrayList<String>();
//        TokenStream stream = null;
//        try {
//            stream = analyzer.tokenStream("content", new StringReader(str));
//            CharTermAttribute attr = stream.addAttribute(CharTermAttribute.class);
//            stream.reset();
//            while(stream.incrementToken()){
//                result.add(attr.toString());
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally{
//            if(stream != null){
//                try {
//                    stream.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        return result;
//    }
//    public static String txt2String(File file){
//        StringBuilder result = new StringBuilder();
//        try{
//            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
//            String s = null;
//            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
//                result.append(System.lineSeparator()+s);
//            }
//            br.close();
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//        return result.toString();
//    }
//    public static void main(String[] args) {
//        String s = txt2String(new File("E://text.txt"));
//        long startFenci = System.currentTimeMillis();
//        List<String> words = getWords(s, new IKAnalyzer());
//        System.out.println(System.currentTimeMillis() - startFenci);
//        System.out.println(words.size());
//        long startPrint = System.currentTimeMillis();
//        words.forEach(x->{});
//        System.out.println(System.currentTimeMillis() - startPrint);
//
//    }
//}
