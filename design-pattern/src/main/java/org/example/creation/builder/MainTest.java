package org.example.creation.builder;

public class MainTest {
    /*
        建造者模式
        产品角色；
        抽象建造者；
        具体建造者；
        创建的东西细节复杂，还必须暴露给使用者。屏蔽过程而不屏蔽细节

        使用场景？
        StringBuilder::append()
        Swagger-ApiBuilder
        Lombok-Builder
        ...
      */
    public static void main(String[] args) {
        AbstractBuilder builder = new AppleBuilder();
        builder.customCpu("A1");
        builder.customDisk("128G");
        builder.customMemory("2G");
        builder.customCamera("索尼");

        Phone phone = builder.getProduct();
        System.out.println(phone);

        //链式调用
        AbstractBuilder builder2 = new AppleBuilder();
        builder2.customCpu("A2").customDisk("128G").customMemory("2G").customCamera("索尼");
        Phone phone2 = builder2.getProduct();
        System.out.println(phone2);
    }
}
