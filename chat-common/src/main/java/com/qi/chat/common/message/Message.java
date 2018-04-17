package com.qi.chat.common.message;

import com.qi.chat.common.utils.Array2NumberConvertor;
import com.qi.chat.common.utils.ArrayUtil;
import com.qi.chat.common.utils.TextUtil;

import java.io.InputStream;

/**
 * 消息封装类 source + port + destination + port + messageType + [fileName + extensionName] + messageSize + message
 * Created by qi on 2018/4/15.
 */
public class Message {
    public static final int SOURCE_LENGHT = 15;
    public static final int DESTINATION_LENGTH = 15;
    public final static int PORT_LENGTH = 4;
    public static final int MESSAGE_TYPE_LENGTH = 4;
    public final static int FILE_NAME_LENGTH = 16;
    public final static int EXTENSION_NAME_LENGTH = 10;
    public final static int MESSAGE_SIZE_LENGTH = 4;

    /**
     * 发送者信息
     */
    protected String source;
    /**
     * 接收者信息
     */
    protected String destination;

    protected int srcPort;

    protected int desPort;
    /**
     * 文件长度
     */
    protected int messageSize;
    /**
     * 消息类型
     */
    protected MessageType messageType;


    public void setHeader(String source, int srcPort, String destination, int desPort) throws Exception {
        if (TextUtil.isEmptyOrNull(source) || TextUtil.isEmptyOrNull(destination)) {
            throw new Exception("地址不明确");
        }
        if (messageType == null) throw new Exception("设置消息类型");
        this.source = source;
        this.destination = destination;
        this.srcPort = srcPort;
        this.desPort = desPort;
    }


    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public int getSrcPort() {
        return srcPort;
    }

    public int getDesPort() {
        return desPort;
    }

    public int getMessageSize() {
        return messageSize;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public enum MessageType {
        TEXT(1), STREAM(2);
        int type;

        MessageType(int type) {
            this.type = type;
        }
    }
}