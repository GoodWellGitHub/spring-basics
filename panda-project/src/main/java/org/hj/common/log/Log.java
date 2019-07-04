package org.hj.common.log;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

public class Log implements Serializable {
  /**
   * 主键
   */
  private String id;

  /**
   * 应用名称
   */
  private String appName;
  /**
   * 日志类型 0操作日志，1异常日志
   */
  private Integer logType;
  /**
   * 操作人
   */
  private String user;
  /**
   * 方法名称
   */
  private String methodName;
  /**
   * 请求参数
   */
  private String requestParams;
  /**
   * 方法描述
   */
  private String methodDescription;
  /**
   * 访问者ip
   */
  private String requestIp;
  /**
   * 请求uri
   */
  private String requestUri;
  /**
   * 请求path
   */
  private String requestPath;
  /**
   * 异常编码
   */
  private String exceptionCode;
  /**
   * 异常详情
   */
  private String exceptionDetail;
  /**
   * 创建时间
   */
  private LocalDateTime createTime;
  /**
   * 请求响应状态
   */
  private String status;
  /**
   * 请求响应内容
   */
  private String content;
}
