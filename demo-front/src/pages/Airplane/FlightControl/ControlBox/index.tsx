import React, { Component, RefObject } from 'react';
import { connect } from 'dva';
import '@ant-design/compatible/assets/index.css';
import { Button, Card, Col, Form, Row, Slider, Tag } from 'antd';
import { ControlBoxProps, ControlBoxState } from '@/pages/Airplane/FlightControl/ControlBox/data';
import numeral from 'numeral';
import nipplejs, {
  EventData,
  JoystickManager,
  JoystickManagerOptions,
  JoystickOutputData,
} from 'nipplejs';
import { FormInstance } from 'antd/lib/form';

class ControlBox extends Component<ControlBoxProps, ControlBoxState> {
  nippleBox: RefObject<any> = React.createRef();

  formRef: RefObject<FormInstance> = React.createRef();

  nipple: JoystickManager | undefined;

  constructor(props: ControlBoxProps) {
    super(props);
    this.state = {
      nippleData: {
        identifier: 0, // 触发它的触摸/鼠标的标识符
        position: {
          // 中心的绝对位置(以像素为单位)
          x: 125,
          y: 95,
        },
        force: 0.2, // 强度 in %
        distance: 25.4, // 到中心的距离(以像素为单位)
        pressure: 0.1, // 触摸产生的压力
        angle: {
          radian: 1.5707963268, // 角的弧度
          degree: 90,
        },
        vector: {
          // 力的单位向量
          x: 0.508,
          y: 3.110602869834277e-17,
        },
        raw: {
          // 注意:角度是一样的，超过了50像素的限制
          distance: 25.4, // 持续超过50像素限制的距离
          position: {
            // 手指/鼠标的位置(以像素为单位)，超出了操纵杆的限制
            x: 125,
            y: 95,
          },
        },
        direction: {
          x: '',
          y: '',
          angle: '',
        },
      },
    };
  }

  componentDidMount(): void {
    const options: JoystickManagerOptions = {
      zone: this.nippleBox.current,
      mode: 'static',
      position: {
        left: '50%',
        top: '50%',
      },
    };
    // this.refs
    this.nipple = nipplejs.create(options);

    // {
    //   identifier: 0,              // 触发它的触摸/鼠标的标识符
    //   position: {                 // 中心的绝对位置(以像素为单位)
    //       x: 125,
    //       y: 95
    //   },
    //   force: 0.2,                 // 强度 in %
    //   distance: 25.4,             // 到中心的距离(以像素为单位)
    //   pressure: 0.1,              // 触摸产生的压力
    //   angle: {
    //       radian: 1.5707963268,   // 角的弧度
    //       degree: 90
    //   },
    //   vector: {                   // 力的单位向量
    //     x: 0.508,
    //     y: 3.110602869834277e-17
    //   },
    //   raw: {                      // 注意:角度是一样的，超过了50像素的限制
    //       distance: 25.4,         // 持续超过50像素限制的距离
    //       position: {             // 手指/鼠标的位置(以像素为单位)，超出了操纵杆的限制
    //           x: 125,
    //           y: 95
    //       }
    //   },
    //   instance: Nipple            // 触发事件的乳头实例
    // }

    this.nipple.on('start', (evt: EventData, data: JoystickOutputData) => {
      console.log(evt, data);
    });
    this.nipple.on('end', (evt: EventData, data: JoystickOutputData) => {
      console.log(evt, data);
    });
    this.nipple.on('move', (evt: EventData, data: JoystickOutputData) => {
      // console.log(evt, data);
      const {
        identifier,
        position,
        force,
        distance,
        pressure,
        angle,
        vector,
        raw,
        direction,
      } = data;
      this.setState({
        nippleData: {
          identifier,
          position,
          force,
          distance,
          pressure,
          angle,
          vector,
          raw,
          direction,
        },
      });
    });
  }

  setFieldsValue = (values: any) => {
    if (this.formRef.current) {
      this.formRef.current.setFieldsValue({ ...values });
    }
  };

  render() {
    // const {setFieldsValue} = this.formRef.current;
    const { setFieldsValue } = this;

    // const {setFieldsValue} = this.props.form;
    const { direction } = this.props;
    const { nippleData } = this.state;
    const formatNumber = (value: number) => numeral(value).format('0.0%');
    return (
      <Form
        ref={this.formRef}
        layout="horizontal"
        // form={form}
        style={{ width: '100%' }}
        initialValues={{
          'direction.rotate': direction.rotate,
          'direction.horizontal': direction.horizontal,
          'direction.forwardBackward': direction.forwardBackward,
          'direction.vertical': direction.vertical,
        }}
      >
        <Row gutter={20} style={{ marginBottom: 20 }}>
          <Col xs={6}>
            <Card title="油门">
              <Row>
                <Col xs={12}>
                  <Form.Item name="direction.vertical">
                    <Slider
                      vertical
                      max={1}
                      min={0}
                      step={0.001}
                      tooltipVisible
                      style={{ height: 200 }}
                      tooltipPlacement="top"
                      tipFormatter={formatNumber}
                    />
                  </Form.Item>
                </Col>
                <Col xs={12}>
                  <Row align="bottom" justify="center">
                    <Col span={24}>
                      <Button
                        type="primary"
                        block
                        style={{ marginBottom: 10 }}
                        onClick={() => {
                          setFieldsValue({ 'direction.vertical': 1 });
                        }}
                      >
                        最大
                      </Button>
                    </Col>
                    <Col span={24}>
                      <Button
                        type="dashed"
                        block
                        style={{ marginBottom: 10 }}
                        onClick={() => {
                          setFieldsValue({ 'direction.vertical': 0.5 });
                        }}
                      >
                        中间
                      </Button>
                    </Col>
                    <Col span={24}>
                      <Button
                        type="primary"
                        block
                        style={{ marginBottom: 10 }}
                        onClick={() => {
                          setFieldsValue({ 'direction.vertical': 0 });
                        }}
                      >
                        最小
                      </Button>
                    </Col>
                  </Row>
                </Col>
              </Row>
            </Card>
          </Col>
          <Col xs={6}>
            <Card title="前进/后退">
              <Row>
                <Col xs={12}>
                  <Form.Item name="direction.forwardBackward">
                    <Slider
                      vertical
                      max={0.5}
                      min={-0.5}
                      step={0.001}
                      tooltipVisible
                      style={{ height: 200 }}
                      tooltipPlacement="top"
                      tipFormatter={formatNumber}
                    />
                  </Form.Item>
                </Col>
                <Col xs={12}>
                  <Button
                    type="primary"
                    block
                    style={{ marginBottom: 10 }}
                    onClick={() => {
                      setFieldsValue({ 'direction.forwardBackward': 0.5 });
                    }}
                  >
                    最大
                  </Button>
                  <Button
                    type="dashed"
                    block
                    style={{ marginBottom: 10 }}
                    onClick={() => {
                      setFieldsValue({ 'direction.forwardBackward': 0 });
                    }}
                  >
                    中间
                  </Button>
                  <Button
                    type="primary"
                    block
                    style={{ marginBottom: 10 }}
                    onClick={() => {
                      setFieldsValue({ 'direction.forwardBackward': -0.5 });
                    }}
                  >
                    最小
                  </Button>
                </Col>
              </Row>
            </Card>
          </Col>
          <Col xs={6}>
            <Card title="向左/向右">
              <Row>
                <Col xs={24}>
                  <Form.Item name="direction.horizontal">
                    <Slider
                      max={0.5}
                      min={-0.5}
                      step={0.001}
                      tooltipVisible
                      tooltipPlacement="top"
                      tipFormatter={formatNumber}
                    />
                  </Form.Item>
                </Col>
                <Col xs={24}>
                  <Button
                    type="primary"
                    block
                    style={{ marginBottom: 10 }}
                    onClick={() => {
                      setFieldsValue({ 'direction.horizontal': 0.5 });
                    }}
                  >
                    最大
                  </Button>
                  <Button
                    type="dashed"
                    block
                    style={{ marginBottom: 10 }}
                    onClick={() => {
                      setFieldsValue({ 'direction.horizontal': 0 });
                    }}
                  >
                    中间
                  </Button>
                  <Button
                    type="primary"
                    block
                    style={{ marginBottom: 10 }}
                    onClick={() => {
                      setFieldsValue({ 'direction.horizontal': -0.5 });
                    }}
                  >
                    最小
                  </Button>
                </Col>
              </Row>
            </Card>
          </Col>
          <Col xs={6}>
            <Card title="原地旋转">
              <Row>
                <Col xs={24}>
                  <Form.Item name="direction.rotate">
                    <Slider
                      max={0.5}
                      min={-0.5}
                      step={0.001}
                      tooltipVisible
                      tooltipPlacement="top"
                      tipFormatter={formatNumber}
                    />
                  </Form.Item>
                </Col>
                <Col xs={24}>
                  <Button
                    type="primary"
                    block
                    style={{ marginBottom: 10 }}
                    onClick={() => {
                      setFieldsValue({ 'direction.rotate': 0.5 });
                    }}
                  >
                    最大
                  </Button>
                  <Button
                    type="dashed"
                    block
                    style={{ marginBottom: 10 }}
                    onClick={() => {
                      setFieldsValue({ 'direction.rotate': 0 });
                    }}
                  >
                    中间
                  </Button>
                  <Button
                    type="primary"
                    block
                    style={{ marginBottom: 10 }}
                    onClick={() => {
                      setFieldsValue({ 'direction.rotate': -0.5 });
                    }}
                  >
                    最小
                  </Button>
                </Col>
              </Row>
            </Card>
          </Col>
        </Row>
        <Row gutter={8} style={{ height: 200 }}>
          <Col span={24}>
            <div
              ref={this.nippleBox}
              style={{ width: '100%', height: 200, background: '#c6c9ee' }}
            />
          </Col>
        </Row>
        <Row gutter={8}>
          <Col span={8}>
            <p>
              <Tag>nippleData?.position.x</Tag>: {nippleData?.position.x}
            </p>
            <p>
              <Tag>nippleData?.position.y</Tag>: {nippleData?.position.y}
            </p>
            <p>
              <Tag>nippleData?.force</Tag>: {nippleData?.force}
            </p>
            <p>
              <Tag>nippleData?.distance</Tag>: {nippleData?.distance}
            </p>
            <p>
              <Tag>nippleData?.pressure</Tag>: {nippleData?.pressure}
            </p>
          </Col>
          <Col span={8}>
            <p>
              <Tag>nippleData?.angle.radian</Tag>: {nippleData?.angle.radian}
            </p>
            <p>
              <Tag>nippleData?.angle.degree</Tag>: {nippleData?.angle.degree}
            </p>
            <p>
              <Tag>nippleData?.vector.x</Tag>: {nippleData?.vector.x}
            </p>
            <p>
              <Tag>nippleData?.vector.y</Tag>: {nippleData?.vector.y}
            </p>
          </Col>
          <Col span={8}>
            <p>
              <Tag>nippleData?.raw.distance</Tag>: {nippleData?.raw.distance}
            </p>
            <p>
              <Tag>nippleData?.raw.position.y</Tag>: {JSON.stringify(nippleData?.raw.position)}
            </p>
            <p>
              <Tag>nippleData?.direction.y</Tag>: {JSON.stringify(nippleData?.direction)}
            </p>
          </Col>
        </Row>
      </Form>
    );
  }
}

export default connect(() => ({}))(ControlBox);
