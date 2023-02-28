package com.chatGpt.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Choice {
  private String text;
  
  private Integer index;
  
  private String logprobs;
  
  @JsonProperty("finish_reason")
  private String finishReason;
  
  public void setText(String text) {
    this.text = text;
  }
  
  public void setIndex(Integer index) {
    this.index = index;
  }
  
  public void setLogprobs(String logprobs) {
    this.logprobs = logprobs;
  }
  
  @JsonProperty("finish_reason")
  public void setFinishReason(String finishReason) {
    this.finishReason = finishReason;
  }
  
  public boolean equals(Object o) {
    if (o == this)
      return true; 
    if (!(o instanceof Choice))
      return false; 
    Choice other = (Choice)o;
    if (!other.canEqual(this))
      return false; 
    Object this$index = getIndex(), other$index = other.getIndex();
    if ((this$index == null) ? (other$index != null) : !this$index.equals(other$index))
      return false; 
    Object this$text = getText(), other$text = other.getText();
    if ((this$text == null) ? (other$text != null) : !this$text.equals(other$text))
      return false; 
    Object this$logprobs = getLogprobs(), other$logprobs = other.getLogprobs();
    if ((this$logprobs == null) ? (other$logprobs != null) : !this$logprobs.equals(other$logprobs))
      return false; 
    Object this$finishReason = getFinishReason(), other$finishReason = other.getFinishReason();
    return !((this$finishReason == null) ? (other$finishReason != null) : !this$finishReason.equals(other$finishReason));
  }
  
  protected boolean canEqual(Object other) {
    return other instanceof Choice;
  }
  
  public int hashCode() {
    int PRIME = 59;
    int result = 1;
    Object $index = getIndex();
    result = result * 59 + (($index == null) ? 43 : $index.hashCode());
    Object $text = getText();
    result = result * 59 + (($text == null) ? 43 : $text.hashCode());
    Object $logprobs = getLogprobs();
    result = result * 59 + (($logprobs == null) ? 43 : $logprobs.hashCode());
    Object $finishReason = getFinishReason();
    return result * 59 + (($finishReason == null) ? 43 : $finishReason.hashCode());
  }
  
  public String toString() {
    return "Choice(text=" + getText() + ", index=" + getIndex() + ", logprobs=" + getLogprobs() + ", finishReason=" + getFinishReason() + ")";
  }
  
  public String getText() {
    return this.text;
  }
  
  public Integer getIndex() {
    return this.index;
  }
  
  public String getLogprobs() {
    return this.logprobs;
  }
  
  public String getFinishReason() {
    return this.finishReason;
  }
}
