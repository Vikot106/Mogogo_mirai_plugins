package ink.moku;

import ink.moku.util.Http2String;
import ink.moku.util.JsonUtil;
import ink.moku.util.MyX509TrustManager;

import java.io.File;

public class GetPic {
    private Http2String http2String = new Http2String();
    private JsonUtil jsonUtil = new JsonUtil();
    private MyX509TrustManager dLandSave = new MyX509TrustManager();
    //private DLandSave dLandSave = new DLandSave();

    public File getCat(){
        String url = jsonUtil.getCat(http2String.sendGet("https://api.thecatapi.com/v1/images/search",""));
        try {
            return dLandSave.DLandSave(url, "./data/mogogo/info/pic/cat");
        }catch (Exception e){
            return getException();
        }
    }

    public File getDog(){
        String url = jsonUtil.getDog(http2String.sendGet("https://dog.ceo/api/breeds/image/random",""));
        try {
            return dLandSave.DLandSave(url, "./data/mogogo/info/pic/dog");
        }catch (Exception e){
            return getException();
        }
    }

    public File getFox(){
        String url = jsonUtil.getFox(http2String.sendGet("https://randomfox.ca/floof/",""));
        try {
            return dLandSave.DLandSave(url, "./data/mogogo/info/pic/fox");
        }catch (Exception e){
            return getException();
        }
    }

    public File getException(){
        return (new File("./data/mogogo/info/pic/500.jpg"));
    }
}
