package org.example.beans;

import java.util.Objects;

public class Goods extends  Object{

    //자바 빈즈에서 필드를 설계할 때 private , protected 제한자를 사용

    // 기본형(원시타입) 자료형 제외하고  , 나머지 자료형의 기본값은 null
    // 초기값(기본값) 이  다름

    // 값이 안들어 올 때 에러 발생하게 하려면 wrapper 타입으로 쓰거나 한다 .


    //beans 규약에 따르면 기본 생성자와 ,getter , setter 를 만들어야 한다

    //final 선언 하면 setter  안뜸
    private  final Long goodsId; //상품 번호
    private  String goodsName; //상품명
    private  Integer price; //상품 가격


    //기본 생성자 필수
    public Goods() {
        this.goodsId= 1L;
    }

    public Goods(String goodsName, Integer price) {
        this();
        this.goodsName = goodsName;
        this.price = price;
    }

    // setter,getter 는 상황에 따라 선택

    public Long getGoodsId() {
        return goodsId;
    }


    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }


    //자바 beans 규약에서는 toString을 재정의 권함
   /*

   @Override
    public String toString() {
        return  String.format("상품번호 :%d,상품명 :%s,상품 가격:%d원",goodsId,goodsName,price);
    }*/

    @Override
    public String toString() {
        return "Goods{" +
                "goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", price=" + price +
                '}';
    }


    //beans 규약에 따라 equals 오버라이딩 하면 hashcode 도 오버라이딩 해야 함
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Goods goods = (Goods) o;
        return Objects.equals(goodsId, goods.goodsId) && Objects.equals(goodsName, goods.goodsName) && Objects.equals(price, goods.price);
    }

    //필드 값이 같으면 hashCode 값을 같게 해준다
    @Override
    public int hashCode() {
        return Objects.hash(goodsId, goodsName, price);
    }
}
