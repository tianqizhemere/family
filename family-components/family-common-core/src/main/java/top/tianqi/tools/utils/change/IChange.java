package top.tianqi.tools.utils.change;

/**
 * 转换接口
 * @Author wkh
 * @Date 2020/8/13 9:28
 */
public interface IChange<T, O> {

    T change(O o);
}
