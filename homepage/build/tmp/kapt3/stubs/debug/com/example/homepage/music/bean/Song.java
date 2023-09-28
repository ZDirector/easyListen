package com.example.homepage.music.bean;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\bw\b\u0086\b\u0018\u00002\u00020\u0001B\u008f\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\b\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u0001\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u0012\u0006\u0010\u0013\u001a\u00020\u0001\u0012\u0006\u0010\u0014\u001a\u00020\u000e\u0012\u0006\u0010\u0015\u001a\u00020\u000e\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u000e\u0012\u0006\u0010\u001b\u001a\u00020\u001c\u0012\u0006\u0010\u001d\u001a\u00020\u001e\u0012\u0006\u0010\u001f\u001a\u00020\u000e\u0012\u0006\u0010 \u001a\u00020\u000e\u0012\u0006\u0010!\u001a\u00020\u000e\u0012\u0006\u0010\"\u001a\u00020\u0006\u0012\u0006\u0010#\u001a\u00020\u000e\u0012\u0006\u0010$\u001a\u00020\u0001\u0012\u0006\u0010%\u001a\u00020\u000e\u0012\u0006\u0010&\u001a\u00020\u0001\u0012\u0006\u0010\'\u001a\u00020\u000e\u0012\u0006\u0010(\u001a\u00020)\u0012\u0006\u0010*\u001a\u00020\u000e\u0012\u0006\u0010+\u001a\u00020,\u0012\u0006\u0010-\u001a\u00020.\u0012\u0006\u0010/\u001a\u00020\u0006\u0012\u0006\u00100\u001a\u00020\u0001\u0012\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00010\b\u0012\u0006\u00102\u001a\u00020\u000e\u0012\u0006\u00103\u001a\u00020\u0001\u0012\u0006\u00104\u001a\u00020\u000e\u0012\u0006\u00105\u001a\u00020\u000e\u0012\u0006\u00106\u001a\u00020\u0001\u0012\u0006\u00107\u001a\u000208\u0012\u0006\u00109\u001a\u00020\u000e\u0012\u0006\u0010:\u001a\u00020\u000e\u0012\u0006\u0010;\u001a\u00020\u0001\u0012\u0006\u0010<\u001a\u00020\u000e\u0012\u0006\u0010=\u001a\u00020\u000e\u00a2\u0006\u0002\u0010>J\t\u0010{\u001a\u00020\u0001H\u00c6\u0003J\t\u0010|\u001a\u00020\u0001H\u00c6\u0003J\t\u0010}\u001a\u00020\u000eH\u00c6\u0003J\t\u0010~\u001a\u00020\u000eH\u00c6\u0003J\t\u0010\u007f\u001a\u00020\u0001H\u00c6\u0003J\n\u0010\u0080\u0001\u001a\u00020\u000eH\u00c6\u0003J\n\u0010\u0081\u0001\u001a\u00020\u000eH\u00c6\u0003J\n\u0010\u0082\u0001\u001a\u00020\u0017H\u00c6\u0003J\n\u0010\u0083\u0001\u001a\u00020\u0019H\u00c6\u0003J\n\u0010\u0084\u0001\u001a\u00020\u000eH\u00c6\u0003J\n\u0010\u0085\u0001\u001a\u00020\u001cH\u00c6\u0003J\n\u0010\u0086\u0001\u001a\u00020\u0004H\u00c6\u0003J\n\u0010\u0087\u0001\u001a\u00020\u001eH\u00c6\u0003J\n\u0010\u0088\u0001\u001a\u00020\u000eH\u00c6\u0003J\n\u0010\u0089\u0001\u001a\u00020\u000eH\u00c6\u0003J\n\u0010\u008a\u0001\u001a\u00020\u000eH\u00c6\u0003J\n\u0010\u008b\u0001\u001a\u00020\u0006H\u00c6\u0003J\n\u0010\u008c\u0001\u001a\u00020\u000eH\u00c6\u0003J\n\u0010\u008d\u0001\u001a\u00020\u0001H\u00c6\u0003J\n\u0010\u008e\u0001\u001a\u00020\u000eH\u00c6\u0003J\n\u0010\u008f\u0001\u001a\u00020\u0001H\u00c6\u0003J\n\u0010\u0090\u0001\u001a\u00020\u000eH\u00c6\u0003J\n\u0010\u0091\u0001\u001a\u00020\u0006H\u00c6\u0003J\n\u0010\u0092\u0001\u001a\u00020)H\u00c6\u0003J\n\u0010\u0093\u0001\u001a\u00020\u000eH\u00c6\u0003J\n\u0010\u0094\u0001\u001a\u00020,H\u00c6\u0003J\n\u0010\u0095\u0001\u001a\u00020.H\u00c6\u0003J\n\u0010\u0096\u0001\u001a\u00020\u0006H\u00c6\u0003J\n\u0010\u0097\u0001\u001a\u00020\u0001H\u00c6\u0003J\u0010\u0010\u0098\u0001\u001a\b\u0012\u0004\u0012\u00020\u00010\bH\u00c6\u0003J\n\u0010\u0099\u0001\u001a\u00020\u000eH\u00c6\u0003J\n\u0010\u009a\u0001\u001a\u00020\u0001H\u00c6\u0003J\n\u0010\u009b\u0001\u001a\u00020\u000eH\u00c6\u0003J\u0010\u0010\u009c\u0001\u001a\b\u0012\u0004\u0012\u00020\u00060\bH\u00c6\u0003J\n\u0010\u009d\u0001\u001a\u00020\u000eH\u00c6\u0003J\n\u0010\u009e\u0001\u001a\u00020\u0001H\u00c6\u0003J\n\u0010\u009f\u0001\u001a\u000208H\u00c6\u0003J\n\u0010\u00a0\u0001\u001a\u00020\u000eH\u00c6\u0003J\n\u0010\u00a1\u0001\u001a\u00020\u000eH\u00c6\u0003J\n\u0010\u00a2\u0001\u001a\u00020\u0001H\u00c6\u0003J\n\u0010\u00a3\u0001\u001a\u00020\u000eH\u00c6\u0003J\n\u0010\u00a4\u0001\u001a\u00020\u000eH\u00c6\u0003J\u0010\u0010\u00a5\u0001\u001a\b\u0012\u0004\u0012\u00020\n0\bH\u00c6\u0003J\n\u0010\u00a6\u0001\u001a\u00020\u0006H\u00c6\u0003J\n\u0010\u00a7\u0001\u001a\u00020\u0006H\u00c6\u0003J\n\u0010\u00a8\u0001\u001a\u00020\u000eH\u00c6\u0003J\n\u0010\u00a9\u0001\u001a\u00020\u000eH\u00c6\u0003J\u00f2\u0003\u0010\u00aa\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\b2\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00012\b\b\u0002\u0010\u0011\u001a\u00020\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u000e2\b\b\u0002\u0010\u0013\u001a\u00020\u00012\b\b\u0002\u0010\u0014\u001a\u00020\u000e2\b\b\u0002\u0010\u0015\u001a\u00020\u000e2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u000e2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u000e2\b\b\u0002\u0010 \u001a\u00020\u000e2\b\b\u0002\u0010!\u001a\u00020\u000e2\b\b\u0002\u0010\"\u001a\u00020\u00062\b\b\u0002\u0010#\u001a\u00020\u000e2\b\b\u0002\u0010$\u001a\u00020\u00012\b\b\u0002\u0010%\u001a\u00020\u000e2\b\b\u0002\u0010&\u001a\u00020\u00012\b\b\u0002\u0010\'\u001a\u00020\u000e2\b\b\u0002\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020\u000e2\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020.2\b\b\u0002\u0010/\u001a\u00020\u00062\b\b\u0002\u00100\u001a\u00020\u00012\u000e\b\u0002\u00101\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\b\b\u0002\u00102\u001a\u00020\u000e2\b\b\u0002\u00103\u001a\u00020\u00012\b\b\u0002\u00104\u001a\u00020\u000e2\b\b\u0002\u00105\u001a\u00020\u000e2\b\b\u0002\u00106\u001a\u00020\u00012\b\b\u0002\u00107\u001a\u0002082\b\b\u0002\u00109\u001a\u00020\u000e2\b\b\u0002\u0010:\u001a\u00020\u000e2\b\b\u0002\u0010;\u001a\u00020\u00012\b\b\u0002\u0010<\u001a\u00020\u000e2\b\b\u0002\u0010=\u001a\u00020\u000eH\u00c6\u0001J\u0015\u0010\u00ab\u0001\u001a\u00020.2\t\u0010\u00ac\u0001\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\n\u0010\u00ad\u0001\u001a\u00020\u000eH\u00d6\u0001J\n\u0010\u00ae\u0001\u001a\u00020\u0006H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bA\u0010BR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\bC\u0010DR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b\u00a2\u0006\b\n\u0000\u001a\u0004\bE\u0010FR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\b\u00a2\u0006\b\n\u0000\u001a\u0004\bG\u0010FR\u0011\u0010\u000b\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\bH\u0010DR\u0011\u0010\f\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\bI\u0010DR\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\bJ\u0010KR\u0011\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\bL\u0010KR\u0011\u0010\u0010\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\bM\u0010@R\u0011\u0010\u0011\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\bN\u0010KR\u0011\u0010\u0012\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\bO\u0010KR\u0011\u0010\u0013\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\bP\u0010@R\u0011\u0010\u0014\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\bQ\u0010KR\u0011\u0010\u0015\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\bR\u0010KR\u0011\u0010\u0016\u001a\u00020\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\bS\u0010TR\u0011\u0010\u0018\u001a\u00020\u0019\u00a2\u0006\b\n\u0000\u001a\u0004\bU\u0010VR\u0011\u0010\u001a\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\bW\u0010KR\u0011\u0010\u001b\u001a\u00020\u001c\u00a2\u0006\b\n\u0000\u001a\u0004\bX\u0010YR\u0011\u0010\u001d\u001a\u00020\u001e\u00a2\u0006\b\n\u0000\u001a\u0004\bZ\u0010[R\u0011\u0010\u001f\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\\\u0010KR\u0011\u0010 \u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b]\u0010KR\u0011\u0010!\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b^\u0010KR\u0011\u0010\"\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b_\u0010DR\u0011\u0010#\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b`\u0010KR\u0011\u0010$\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\ba\u0010@R\u0011\u0010%\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\bb\u0010KR\u0011\u0010&\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\bc\u0010@R\u0011\u0010\'\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\bd\u0010KR\u0011\u0010(\u001a\u00020)\u00a2\u0006\b\n\u0000\u001a\u0004\be\u0010fR\u0011\u0010*\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\bg\u0010KR\u0011\u0010+\u001a\u00020,\u00a2\u0006\b\n\u0000\u001a\u0004\bh\u0010iR\u0011\u0010-\u001a\u00020.\u00a2\u0006\b\n\u0000\u001a\u0004\bj\u0010kR\u0011\u0010/\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\bl\u0010DR\u0011\u00100\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\bm\u0010@R\u0017\u00101\u001a\b\u0012\u0004\u0012\u00020\u00010\b\u00a2\u0006\b\n\u0000\u001a\u0004\bn\u0010FR\u0011\u00102\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\bo\u0010KR\u0011\u00103\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\bp\u0010@R\u0011\u00104\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\bq\u0010KR\u0011\u00105\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\br\u0010KR\u0011\u00106\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\bs\u0010@R\u0011\u00107\u001a\u000208\u00a2\u0006\b\n\u0000\u001a\u0004\bt\u0010uR\u0011\u00109\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\bv\u0010KR\u0011\u0010:\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\bw\u0010KR\u0011\u0010;\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\bx\u0010@R\u0011\u0010<\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\by\u0010KR\u0011\u0010=\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\bz\u0010K\u00a8\u0006\u00af\u0001"}, d2 = {"Lcom/example/homepage/music/bean/Song;", "", "a", "al", "Lcom/example/homepage/music/bean/Al;", "alg", "", "alia", "", "ar", "Lcom/example/homepage/music/bean/Ar;", "cd", "cf", "copyright", "", "cp", "crbt", "djId", "dt", "entertainmentTags", "fee", "ftype", "h", "Lcom/example/homepage/music/bean/H;", "hr", "Lcom/example/homepage/music/bean/Hr;", "id", "l", "Lcom/example/homepage/music/bean/L;", "m", "Lcom/example/homepage/music/bean/M;", "mark", "mst", "mv", "name", "no", "noCopyrightRcmd", "originCoverType", "originSongSimpleData", "pop", "privilege", "Lcom/example/homepage/music/bean/Privilege;", "pst", "publishTime", "", "resourceState", "", "rt", "rtUrl", "rtUrls", "rtype", "rurl", "s_id", "single", "songJumpInfo", "sq", "Lcom/example/homepage/music/bean/Sq;", "st", "t", "tagPicList", "v", "version", "(Ljava/lang/Object;Lcom/example/homepage/music/bean/Al;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;IILjava/lang/Object;IILjava/lang/Object;IILcom/example/homepage/music/bean/H;Lcom/example/homepage/music/bean/Hr;ILcom/example/homepage/music/bean/L;Lcom/example/homepage/music/bean/M;IIILjava/lang/String;ILjava/lang/Object;ILjava/lang/Object;ILcom/example/homepage/music/bean/Privilege;IJZLjava/lang/String;Ljava/lang/Object;Ljava/util/List;ILjava/lang/Object;IILjava/lang/Object;Lcom/example/homepage/music/bean/Sq;IILjava/lang/Object;II)V", "getA", "()Ljava/lang/Object;", "getAl", "()Lcom/example/homepage/music/bean/Al;", "getAlg", "()Ljava/lang/String;", "getAlia", "()Ljava/util/List;", "getAr", "getCd", "getCf", "getCopyright", "()I", "getCp", "getCrbt", "getDjId", "getDt", "getEntertainmentTags", "getFee", "getFtype", "getH", "()Lcom/example/homepage/music/bean/H;", "getHr", "()Lcom/example/homepage/music/bean/Hr;", "getId", "getL", "()Lcom/example/homepage/music/bean/L;", "getM", "()Lcom/example/homepage/music/bean/M;", "getMark", "getMst", "getMv", "getName", "getNo", "getNoCopyrightRcmd", "getOriginCoverType", "getOriginSongSimpleData", "getPop", "getPrivilege", "()Lcom/example/homepage/music/bean/Privilege;", "getPst", "getPublishTime", "()J", "getResourceState", "()Z", "getRt", "getRtUrl", "getRtUrls", "getRtype", "getRurl", "getS_id", "getSingle", "getSongJumpInfo", "getSq", "()Lcom/example/homepage/music/bean/Sq;", "getSt", "getT", "getTagPicList", "getV", "getVersion", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component4", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "homepage_debug"})
public final class Song {
    @org.jetbrains.annotations.NotNull
    private final java.lang.Object a = null;
    @org.jetbrains.annotations.NotNull
    private final com.example.homepage.music.bean.Al al = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String alg = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<java.lang.String> alia = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.example.homepage.music.bean.Ar> ar = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String cd = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String cf = null;
    private final int copyright = 0;
    private final int cp = 0;
    @org.jetbrains.annotations.NotNull
    private final java.lang.Object crbt = null;
    private final int djId = 0;
    private final int dt = 0;
    @org.jetbrains.annotations.NotNull
    private final java.lang.Object entertainmentTags = null;
    private final int fee = 0;
    private final int ftype = 0;
    @org.jetbrains.annotations.NotNull
    private final com.example.homepage.music.bean.H h = null;
    @org.jetbrains.annotations.NotNull
    private final com.example.homepage.music.bean.Hr hr = null;
    private final int id = 0;
    @org.jetbrains.annotations.NotNull
    private final com.example.homepage.music.bean.L l = null;
    @org.jetbrains.annotations.NotNull
    private final com.example.homepage.music.bean.M m = null;
    private final int mark = 0;
    private final int mst = 0;
    private final int mv = 0;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String name = null;
    private final int no = 0;
    @org.jetbrains.annotations.NotNull
    private final java.lang.Object noCopyrightRcmd = null;
    private final int originCoverType = 0;
    @org.jetbrains.annotations.NotNull
    private final java.lang.Object originSongSimpleData = null;
    private final int pop = 0;
    @org.jetbrains.annotations.NotNull
    private final com.example.homepage.music.bean.Privilege privilege = null;
    private final int pst = 0;
    private final long publishTime = 0L;
    private final boolean resourceState = false;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String rt = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.Object rtUrl = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<java.lang.Object> rtUrls = null;
    private final int rtype = 0;
    @org.jetbrains.annotations.NotNull
    private final java.lang.Object rurl = null;
    private final int s_id = 0;
    private final int single = 0;
    @org.jetbrains.annotations.NotNull
    private final java.lang.Object songJumpInfo = null;
    @org.jetbrains.annotations.NotNull
    private final com.example.homepage.music.bean.Sq sq = null;
    private final int st = 0;
    private final int t = 0;
    @org.jetbrains.annotations.NotNull
    private final java.lang.Object tagPicList = null;
    private final int v = 0;
    private final int version = 0;
    
    @org.jetbrains.annotations.NotNull
    public final com.example.homepage.music.bean.Song copy(@org.jetbrains.annotations.NotNull
    java.lang.Object a, @org.jetbrains.annotations.NotNull
    com.example.homepage.music.bean.Al al, @org.jetbrains.annotations.NotNull
    java.lang.String alg, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> alia, @org.jetbrains.annotations.NotNull
    java.util.List<com.example.homepage.music.bean.Ar> ar, @org.jetbrains.annotations.NotNull
    java.lang.String cd, @org.jetbrains.annotations.NotNull
    java.lang.String cf, int copyright, int cp, @org.jetbrains.annotations.NotNull
    java.lang.Object crbt, int djId, int dt, @org.jetbrains.annotations.NotNull
    java.lang.Object entertainmentTags, int fee, int ftype, @org.jetbrains.annotations.NotNull
    com.example.homepage.music.bean.H h, @org.jetbrains.annotations.NotNull
    com.example.homepage.music.bean.Hr hr, int id, @org.jetbrains.annotations.NotNull
    com.example.homepage.music.bean.L l, @org.jetbrains.annotations.NotNull
    com.example.homepage.music.bean.M m, int mark, int mst, int mv, @org.jetbrains.annotations.NotNull
    java.lang.String name, int no, @org.jetbrains.annotations.NotNull
    java.lang.Object noCopyrightRcmd, int originCoverType, @org.jetbrains.annotations.NotNull
    java.lang.Object originSongSimpleData, int pop, @org.jetbrains.annotations.NotNull
    com.example.homepage.music.bean.Privilege privilege, int pst, long publishTime, boolean resourceState, @org.jetbrains.annotations.NotNull
    java.lang.String rt, @org.jetbrains.annotations.NotNull
    java.lang.Object rtUrl, @org.jetbrains.annotations.NotNull
    java.util.List<? extends java.lang.Object> rtUrls, int rtype, @org.jetbrains.annotations.NotNull
    java.lang.Object rurl, int s_id, int single, @org.jetbrains.annotations.NotNull
    java.lang.Object songJumpInfo, @org.jetbrains.annotations.NotNull
    com.example.homepage.music.bean.Sq sq, int st, int t, @org.jetbrains.annotations.NotNull
    java.lang.Object tagPicList, int v, int version) {
        return null;
    }
    
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.String toString() {
        return null;
    }
    
    public Song(@org.jetbrains.annotations.NotNull
    java.lang.Object a, @org.jetbrains.annotations.NotNull
    com.example.homepage.music.bean.Al al, @org.jetbrains.annotations.NotNull
    java.lang.String alg, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> alia, @org.jetbrains.annotations.NotNull
    java.util.List<com.example.homepage.music.bean.Ar> ar, @org.jetbrains.annotations.NotNull
    java.lang.String cd, @org.jetbrains.annotations.NotNull
    java.lang.String cf, int copyright, int cp, @org.jetbrains.annotations.NotNull
    java.lang.Object crbt, int djId, int dt, @org.jetbrains.annotations.NotNull
    java.lang.Object entertainmentTags, int fee, int ftype, @org.jetbrains.annotations.NotNull
    com.example.homepage.music.bean.H h, @org.jetbrains.annotations.NotNull
    com.example.homepage.music.bean.Hr hr, int id, @org.jetbrains.annotations.NotNull
    com.example.homepage.music.bean.L l, @org.jetbrains.annotations.NotNull
    com.example.homepage.music.bean.M m, int mark, int mst, int mv, @org.jetbrains.annotations.NotNull
    java.lang.String name, int no, @org.jetbrains.annotations.NotNull
    java.lang.Object noCopyrightRcmd, int originCoverType, @org.jetbrains.annotations.NotNull
    java.lang.Object originSongSimpleData, int pop, @org.jetbrains.annotations.NotNull
    com.example.homepage.music.bean.Privilege privilege, int pst, long publishTime, boolean resourceState, @org.jetbrains.annotations.NotNull
    java.lang.String rt, @org.jetbrains.annotations.NotNull
    java.lang.Object rtUrl, @org.jetbrains.annotations.NotNull
    java.util.List<? extends java.lang.Object> rtUrls, int rtype, @org.jetbrains.annotations.NotNull
    java.lang.Object rurl, int s_id, int single, @org.jetbrains.annotations.NotNull
    java.lang.Object songJumpInfo, @org.jetbrains.annotations.NotNull
    com.example.homepage.music.bean.Sq sq, int st, int t, @org.jetbrains.annotations.NotNull
    java.lang.Object tagPicList, int v, int version) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.Object component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.Object getA() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.homepage.music.bean.Al component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.homepage.music.bean.Al getAl() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getAlg() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.String> component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.String> getAlia() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.example.homepage.music.bean.Ar> component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.example.homepage.music.bean.Ar> getAr() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getCd() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getCf() {
        return null;
    }
    
    public final int component8() {
        return 0;
    }
    
    public final int getCopyright() {
        return 0;
    }
    
    public final int component9() {
        return 0;
    }
    
    public final int getCp() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.Object component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.Object getCrbt() {
        return null;
    }
    
    public final int component11() {
        return 0;
    }
    
    public final int getDjId() {
        return 0;
    }
    
    public final int component12() {
        return 0;
    }
    
    public final int getDt() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.Object component13() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.Object getEntertainmentTags() {
        return null;
    }
    
    public final int component14() {
        return 0;
    }
    
    public final int getFee() {
        return 0;
    }
    
    public final int component15() {
        return 0;
    }
    
    public final int getFtype() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.homepage.music.bean.H component16() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.homepage.music.bean.H getH() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.homepage.music.bean.Hr component17() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.homepage.music.bean.Hr getHr() {
        return null;
    }
    
    public final int component18() {
        return 0;
    }
    
    public final int getId() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.homepage.music.bean.L component19() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.homepage.music.bean.L getL() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.homepage.music.bean.M component20() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.homepage.music.bean.M getM() {
        return null;
    }
    
    public final int component21() {
        return 0;
    }
    
    public final int getMark() {
        return 0;
    }
    
    public final int component22() {
        return 0;
    }
    
    public final int getMst() {
        return 0;
    }
    
    public final int component23() {
        return 0;
    }
    
    public final int getMv() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component24() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getName() {
        return null;
    }
    
    public final int component25() {
        return 0;
    }
    
    public final int getNo() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.Object component26() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.Object getNoCopyrightRcmd() {
        return null;
    }
    
    public final int component27() {
        return 0;
    }
    
    public final int getOriginCoverType() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.Object component28() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.Object getOriginSongSimpleData() {
        return null;
    }
    
    public final int component29() {
        return 0;
    }
    
    public final int getPop() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.homepage.music.bean.Privilege component30() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.homepage.music.bean.Privilege getPrivilege() {
        return null;
    }
    
    public final int component31() {
        return 0;
    }
    
    public final int getPst() {
        return 0;
    }
    
    public final long component32() {
        return 0L;
    }
    
    public final long getPublishTime() {
        return 0L;
    }
    
    public final boolean component33() {
        return false;
    }
    
    public final boolean getResourceState() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component34() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getRt() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.Object component35() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.Object getRtUrl() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.Object> component36() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.Object> getRtUrls() {
        return null;
    }
    
    public final int component37() {
        return 0;
    }
    
    public final int getRtype() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.Object component38() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.Object getRurl() {
        return null;
    }
    
    public final int component39() {
        return 0;
    }
    
    public final int getS_id() {
        return 0;
    }
    
    public final int component40() {
        return 0;
    }
    
    public final int getSingle() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.Object component41() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.Object getSongJumpInfo() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.homepage.music.bean.Sq component42() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.homepage.music.bean.Sq getSq() {
        return null;
    }
    
    public final int component43() {
        return 0;
    }
    
    public final int getSt() {
        return 0;
    }
    
    public final int component44() {
        return 0;
    }
    
    public final int getT() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.Object component45() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.Object getTagPicList() {
        return null;
    }
    
    public final int component46() {
        return 0;
    }
    
    public final int getV() {
        return 0;
    }
    
    public final int component47() {
        return 0;
    }
    
    public final int getVersion() {
        return 0;
    }
}