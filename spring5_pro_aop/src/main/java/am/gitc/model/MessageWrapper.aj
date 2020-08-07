package am.gitc.model;

public aspect MessageWrapper {

    private String  prefix;
    private String  suffix;

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    pointcut doWriting() :
            execution(* am.gitc.model.MessageWriter.writeMessage());
    before() : doWriting() {
        System.out.println(prefix);
    }

    after() : doWriting() {
        System.out.println(suffix);
    }

}
