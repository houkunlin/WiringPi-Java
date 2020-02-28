import React, { Component } from 'react';
import { connect } from 'dva';
import '@ant-design/compatible/assets/index.css';
import { DatePicker, Form, Switch } from 'antd';
import moment from 'moment';
import { PowerBoxProps, PowerBoxState } from './data';

class Power extends Component<PowerBoxProps, PowerBoxState> {
  constructor(props: PowerBoxProps) {
    super(props);
    this.state = {};
  }

  render() {
    const { data } = this.props;
    return (
      <Form
        layout="inline"
        initialValues={{
          'power.open': data.open,
          'power.startTime': data.startTime == null ? null : moment(data.startTime),
          'power.endTime': data.endTime == null ? null : moment(data.endTime),
        }}
      >
        <Form.Item label="电源状态" name="power.open">
          <Switch checkedChildren="已开启" unCheckedChildren="已关闭" />
        </Form.Item>
        <Form.Item label="开启时间" name="power.startTime">
          <DatePicker format="YYYY-MM-DD HH:mm:ss" disabled placeholder="电源未开始运行" />
        </Form.Item>
        <Form.Item label="关闭时间" name="power.endTime">
          <DatePicker format="YYYY-MM-DD HH:mm:ss" disabled placeholder="电源未结束运行" />
        </Form.Item>
      </Form>
    );
  }
}

export default connect(() => ({}))(Power);
