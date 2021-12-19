package io.github.Haoke98;

public class UCC {

    public static String GetOrganizationType(String ucc) {
        switch (ucc.charAt(0)) {
            case '1':
                //机构编制
                switch (ucc.charAt(1)) {
                    case '1':
                        return "机关";
                    case '2':
                        return "事业单位";
                    case '3':
                        return "中央编办直接管理机构编制的群众团体";
                    case '9':
                        return "其他机构";
                }
                break;
            case '5':
                //民政
                switch (ucc.charAt(1)) {
                    case '1':
                        return "社会团体";
                    case '2':
                        return "民办非企业单位";
                    case '3':
                        return "基金会";
                    case '9':
                        return "其他民政单位";
                }
                break;
            case '9':
                //工商
                switch (ucc.charAt(1)) {
                    case '1':
                        return "企业";
                    case '2':
                        return "个体商户";
                    case '3':
                        return "农民专业合作社";
                }
                break;
            case 'Y':
                //其他
                switch (ucc.charAt(1)) {
                    case '1':
                        return "其他";
                }
                break;
            default:
                return "其他";
        }
        return "不匹配,没法确定企业类型";
    }


    public static String GetOrganizationShortType(String ucc) {
        switch (ucc.charAt(0)) {
            case '1':
                //机构编制
                switch (ucc.charAt(1)) {
                    case '1':
                        return "机";
                    case '2':
                        return "事";
                    case '3':
                        return "中";
                    case '9':
                        return "其他机构";
                }
            case '5':
                //民政
                switch (ucc.charAt(1)) {
                    case '1':
                        return "商";
                    case '2':
                        return "民";
                    case '3':
                        return "基";
                    default:
                        return "其他";
                }
            case '7':
                return "协";
            case '8':
                return "商";
            case '9':
                //工商
                switch (ucc.charAt(1)) {
                    case '1':
                        return "企";
                    case '2':
                        return "个";
                    case '3':
                        return "农";
                }
            case 'Y':
                return "其";
            default:
                return "其他";
        }
    }
}
