package net.utility;

public class Paging {  
  /**
   * ?«? ??? ??΄μ§?, 1 ??΄μ§?λΆ??° ??
   * ??¬ ??΄μ§?: 11 / 22   [?΄? ] 11 12 13 14 15 16 17 18 19 20 [?€?]
   * 
   * @param totalRecord ? μ²? ? μ½λ?
   * @param nowPage     ??¬ ??΄μ§?
   * @param recordPerPage ??΄μ§??Ή ? μ½λ ? 
   * @return
   */
  public String paging(int totalRecord, int nowPage, int recordPerPage, String col, String word, String filenm){
    int pagePerBlock = 10; // λΈλ­?Ή ??΄μ§? ?
    int totalPage = (int)(Math.ceil((double)totalRecord/recordPerPage)); // ? μ²? ??΄μ§? 
    int totalGrp = (int)(Math.ceil((double)totalPage/pagePerBlock));// ? μ²? κ·Έλ£Ή
    int nowGrp = (int)(Math.ceil((double)nowPage/pagePerBlock));    // ??¬ κ·Έλ£Ή
    int startPage = ((nowGrp - 1) * pagePerBlock) + 1; // ?Ή?  κ·Έλ£Ή? ??΄μ§? λͺ©λ‘ ?? 
    int endPage = (nowGrp * pagePerBlock);             // ?Ή?  κ·Έλ£Ή? ??΄μ§? λͺ©λ‘ μ’λ£  
    
    StringBuffer str = new StringBuffer();
    
    str.append("<style>");
    str.append("  #paging {text-align: center; margin-top: 5px; font-size: 1em;}");
    str.append("  #paging A:link {text-decoration:none; color:black; font-size: 1em;}");
    str.append("  #paging A:hover{text-decoration:underline; background-color: #ffffff; color:black; font-size: 1em;}");
    str.append("  #paging A:visited {text-decoration:none;color:black; font-size: 1em;}");
    str.append("</style>");
    str.append("<DIV id='paging'>");
    //str.append("??¬ ??΄μ§?: " + nowPage + " / " + totalPage + "&nbsp;&nbsp;");

    int _nowPage = (nowGrp-1) * pagePerBlock; // 10κ°? ?΄?  ??΄μ§?λ‘? ?΄?
    if (nowGrp >= 2){
      str.append("[<A href='./"+filenm+"?col="+col+"&word="+word+"&nowPage="+_nowPage+"'>?΄? </A>]");
    }

    for(int i=startPage; i<=endPage; i++){
      if (i > totalPage){
        break;
      }
 
      if (nowPage == i){ // ??¬ ??΄μ§??΄λ©? κ°μ‘° ?¨κ³?
        str.append("<span style='font-size: 1.2em; font-weight: bold;'>"+i+"</span>&nbsp;");  
      }else{
        str.append("<A href='./"+filenm+"?col="+col+"&word="+word+"&nowPage="+i+"'>"+i+"</A>&nbsp;");
      }      
    }
    
    _nowPage = (nowGrp * pagePerBlock)+1; // 10κ°? ?€? ??΄μ§?λ‘? ?΄?
    if (nowGrp < totalGrp){
      str.append("[<A href='./"+filenm+"?col="+col+"&word="+word+"&nowPage="+_nowPage+"'>?€?</A>]");
    }
    str.append("</DIV>");
    
    return str.toString();
  }
  
  /**
   * SPAN?κ·Έλ?? ?΄?©? λ°μ€ λͺ¨λΈ? μ§??, 1 ??΄μ§?λΆ??° ??
   * ??¬ ??΄μ§?: 11 / 22   [?΄? ] 11 12 13 14 15 16 17 18 19 20 [?€?]
   * 
   * @param totalRecord ? μ²? ? μ½λ?
   * @param nowPage     ??¬ ??΄μ§?
   * @param recordPerPage ??΄μ§??Ή ? μ½λ ? 
   * @return
   */
  public String paging2(int totalRecord, int nowPage, int recordPerPage, String col, String word, String filenm){
    int pagePerBlock = 10; // λΈλ­?Ή ??΄μ§? ?
    int totalPage = (int)(Math.ceil((double)totalRecord/recordPerPage)); // ? μ²? ??΄μ§? 
    int totalGrp = (int)(Math.ceil((double)totalPage/pagePerBlock));// ? μ²? κ·Έλ£Ή
    int nowGrp = (int)(Math.ceil((double)nowPage/pagePerBlock));    // ??¬ κ·Έλ£Ή
    int startPage = ((nowGrp - 1) * pagePerBlock) + 1; // ?Ή?  κ·Έλ£Ή? ??΄μ§? λͺ©λ‘ ?? 
    int endPage = (nowGrp * pagePerBlock);             // ?Ή?  κ·Έλ£Ή? ??΄μ§? λͺ©λ‘ μ’λ£  
    
    StringBuffer str = new StringBuffer();
    
    str.append("<style>");
    str.append("  #paging {text-align: center; margin-top: 5px; font-size: 1em;}");
    str.append("  #paging A:link {text-decoration:none; color:black; font-size: 1em;}");
    str.append("  #paging A:hover{text-decoration:none; background-color: #CCCCCC; color:black; font-size: 1em;}");
    str.append("  #paging A:visited {text-decoration:none;color:black; font-size: 1em;}");
    str.append("  .span_box_1{");
    str.append("    font-size: 1em;");
    str.append("    border: 1px;");
    str.append("    border-style: solid;");
    str.append("    border-color: #cccccc;");
    str.append("    padding:0px 0px 0px 0px; /*?, ?€λ₯Έμͺ½, ??, ?Όμͺ?*/");
    str.append("    margin:0px 0px 0px 0px; /*?, ?€λ₯Έμͺ½, ??, ?Όμͺ?*/");
    str.append("  }");
    str.append("  .span_box_2{");
    str.append("    background-color: #CCCCCC;");
    str.append("    font-size: 1em;");
    str.append("    border: 1px;");
    str.append("    border-style: solid;");
    str.append("    border-color: #cccccc;");
    str.append("    padding:0px 0px 0px 0px; /*?, ?€λ₯Έμͺ½, ??, ?Όμͺ?*/");
    str.append("    margin:0px 0px 0px 0px; /*?, ?€λ₯Έμͺ½, ??, ?Όμͺ?*/");
    str.append("  }");
    str.append("</style>");
    str.append("<DIV id='paging'>");
    //str.append("??¬ ??΄μ§?: " + nowPage + " / " + totalPage + "&nbsp;&nbsp;");

    int _nowPage = (nowGrp-1) * pagePerBlock; // 10κ°? ?΄?  ??΄μ§?λ‘? ?΄?
    if (nowGrp >= 2){
      str.append("<A href='./"+filenm+"?col="+col+"&word="+word+"&nowPage="+_nowPage+"'><span class='span_box_1'>?΄? </span></A>&nbsp;");
    }

    for(int i=startPage; i<=endPage; i++){
      if (i > totalPage){
        break;
      }
 
      if (nowPage == i){
        str.append("<span class='span_box_2'>&nbsp;"+i+"&nbsp;</span>&nbsp;");
      }else{
        str.append("<A href='./"+filenm+"?col="+col+"&word="+word+"&nowPage="+i+"'><span class='span_box_1'>&nbsp;"+i+"&nbsp;</span></A>&nbsp;");  
      }
    }
    
    _nowPage = (nowGrp * pagePerBlock)+1; // 10κ°? ?€? ??΄μ§?λ‘? ?΄?
    if (nowGrp < totalGrp){
      str.append("<A href='./"+filenm+"?col="+col+"&word="+word+"&nowPage="+_nowPage+"'><span class='span_box_1'>?€?</span></A>&nbsp;");
    }
    str.append("</DIV>");
    
    return str.toString();
  }
  
  /**
   * SPAN?κ·Έλ?? ?΄?©? λ°μ€ λͺ¨λΈ? μ§??, 1 ??΄μ§?λΆ??° ??
   * ??¬ ??΄μ§?: 11 / 22   [?΄? ] 11 12 13 14 15 16 17 18 19 20 [?€?]
   * 
   * @param totalRecord ? μ²? ? μ½λ?
   * @param nowPage     ??¬ ??΄μ§?
   * @param recordPerPage ??΄μ§??Ή ? μ½λ ? 
   * @return
   */
  public String paging3(int totalRecord, int nowPage, int recordPerPage, String col, String word, String filenm){
    int pagePerBlock = 10; // λΈλ­?Ή ??΄μ§? ?
    int totalPage = (int)(Math.ceil((double)totalRecord/recordPerPage)); // ? μ²? ??΄μ§? 
    int totalGrp = (int)(Math.ceil((double)totalPage/pagePerBlock));// ? μ²? κ·Έλ£Ή
    int nowGrp = (int)(Math.ceil((double)nowPage/pagePerBlock));    // ??¬ κ·Έλ£Ή
    int startPage = ((nowGrp - 1) * pagePerBlock) + 1; // ?Ή?  κ·Έλ£Ή? ??΄μ§? λͺ©λ‘ ?? 
    int endPage = (nowGrp * pagePerBlock);             // ?Ή?  κ·Έλ£Ή? ??΄μ§? λͺ©λ‘ μ’λ£  
    
    StringBuffer str = new StringBuffer();
    
    str.append("<style>");
    str.append("  #paging {text-align: center; margin-top: 5px; font-size: 1em;}");
    str.append("  #paging A:link {text-decoration:none; color:black; font-size: 1em;}");
    str.append("  #paging A:hover{text-decoration:none; background-color: #CCCCCC; color:black; font-size: 1em;}");
    str.append("  #paging A:visited {text-decoration:none;color:black; font-size: 1em;}");
    str.append("  .span_box_1{");
    str.append("    font-size: 1em;");
    str.append("    border: 1px;");
    str.append("    border-style: solid;");
    str.append("    border-color: #cccccc;");
    str.append("    padding:0px 0px 0px 0px; /*?, ?€λ₯Έμͺ½, ??, ?Όμͺ?*/");
    str.append("    margin:0px 0px 0px 0px; /*?, ?€λ₯Έμͺ½, ??, ?Όμͺ?*/");
    str.append("  }");
    str.append("  .span_box_2{");
    str.append("    background-color: #668db4;");
    str.append("    color: #FFFFFF;");
    str.append("    font-size: 1em;");
    str.append("    border: 1px;");
    str.append("    border-style: solid;");
    str.append("    border-color: #cccccc;");
    str.append("    padding:0px 0px 0px 0px; /*?, ?€λ₯Έμͺ½, ??, ?Όμͺ?*/");
    str.append("    margin:0px 0px 0px 0px; /*?, ?€λ₯Έμͺ½, ??, ?Όμͺ?*/");
    str.append("  }");
    str.append("</style>");
    str.append("<DIV id='paging'>");
    //str.append("??¬ ??΄μ§?: " + nowPage + " / " + totalPage + "&nbsp;&nbsp;");

    int _nowPage = (nowGrp-1) * pagePerBlock; // 10κ°? ?΄?  ??΄μ§?λ‘? ?΄?
    if (nowGrp >= 2){
      str.append("<A href='./"+filenm+"?col="+col+"&word="+word+"&nowPage="+_nowPage+"'><span class='span_box_1'>?΄? </span></A>&nbsp;");
    }

    for(int i=startPage; i<=endPage; i++){
      if (i > totalPage){
        break;
      }
 
      if (nowPage == i){
        str.append("<span class='span_box_2'>&nbsp;"+i+"&nbsp;</span>&nbsp;");
      }else{
        str.append("<A href='./"+filenm+"?col="+col+"&word="+word+"&nowPage="+i+"'><span class='span_box_1'>&nbsp;"+i+"&nbsp;</span></A>&nbsp;");  
      }
    }
    
    _nowPage = (nowGrp * pagePerBlock)+1; // 10κ°? ?€? ??΄μ§?λ‘? ?΄?
    if (nowGrp < totalGrp){
      str.append("<A href='./"+filenm+"?col="+col+"&word="+word+"&nowPage="+_nowPage+"'><span class='span_box_1'>?€?</span></A>&nbsp;");
    }
    str.append("</DIV>");
    
    return str.toString();
  }
}  
