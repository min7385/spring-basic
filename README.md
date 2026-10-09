<details>
<summary>28강 - 스프링 빈 조회(기본)</summary>
<div markdown="1">

## 스프링 빈 조회 목적

스프링 컨테이너에 객체가 제대로 등록되었는지 확인하고, 그 동작을 테스트하기 위함이다.

## 스프링 빈 조회 방법

- `ac.getBean(빈이름, 타입)`
- `ac.getBean(타입)`

## 스프링 빈 조회 시 예외

조회 대상 스프링 빈이 없으면 예외가 발생한다.

`NoSuchBeanDefinitionException`: 조회하려는 스프링 빈이 존재하지 않을 때 발생한다.

</div>
</details>

<details>
<summary>29강 - 스프링 빈 조회(동일한 타입 중복)</summary>
<div markdown="1">

## 동일한 타입의 스프링 빈 조회

타입으로 스프링 빈을 조회할 때 동일한 타입의 빈이 둘 이상 존재하면 **중복 오류**가 발생한다.

- `Bean` 이름을 지정하여 해결할 수 있다.
- `ac.getBeansOfType()`을 사용하면 해당 타입의 **모든 빈**을 조회할 수 있다.

</div>
</details>

<details>
<summary>30강 - 스프링 빈 조회(상속관계)</summary>
<div markdown="1">

## 상속관계에서의 스프링 빈 조회

- 부모 타입으로 조회하면 **자식 타입의 빈도 함께 조회**한다.
- 따라서 모든 자바 객체의 최고 부모인 `Object` 타입으로 조회하면 **모든 스프링 빈을 조회**할 수 있다.

</div>
</details>

<details>
<summary>31강 - BeanFactory와 ApplicationContext</summary>
<div markdown="1">

## BeanFactory

- 스프링 컨테이너의 최상위 인터페이스이다.
- 스프링 빈을 관리하고 조회하는 역할을 담당한다.

## ApplicationContext

- `BeanFactory`의 기능을 모두 상속받아 제공한다.
- 빈을 관리하고 조회하는 역할 외에 부가 기능을 제공한다.
- 주요 부가 기능 관련 인터페이스:
    - `MessageSource`
    - `EnvironmentCapable`
    - `ApplicationEventPublisher`
    - `ResourceLoader`

</div>
</details>

<details>
<summary>32강 - BeanDefinition</summary>
<div markdown="1">

## BeanDefinition
- 빈 설정 정보를 추상화한 메타 정보이다.
- 스프링 컨테이너는 설정이 자바 코드인지 XML인지 직접 구분하지 않는다.
- 각 설정 정보를 `BeanDefinition`으로 변환한 뒤, 해당 정보만을 바탕으로 빈을 생성한다.
- 이를 통해 **다양한 설정 형식을 지원할 수 있다.**

</div>
</details>